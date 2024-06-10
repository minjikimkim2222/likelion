package org.example.restexam.controller;

import jakarta.servlet.http.HttpServletResponse;
import org.example.restexam.domain.UploadInfo;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.*;
import org.springframework.web.multipart.MultipartFile;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


@RestController
public class FileController {

    @PostMapping("/upload")
    public ResponseEntity<String> handlerFileUpload(
            @RequestParam("catFile") MultipartFile file,
            @RequestPart("info") UploadInfo uploadInfo // 멀티타입 request의 특정파트를. 자바 객체로 변환시키는..
    ) {
        String message = "";

        try {
            // 파일 저장
            File dest = new File("/Users/minji/Desktop/temp/upload/" + file.getOriginalFilename());
            file.transferTo(dest);

            // 로그 출력
            System.out.println(file.getOriginalFilename() + "==================");
            System.out.println(uploadInfo.getDescription() + "==================");
            System.out.println(uploadInfo.getTag() + "==================");

            message = "You successfully uploaded " + file.getOriginalFilename() + "!";
            return ResponseEntity.ok().body(message);
        } catch (IOException e) {
            message = "FAIL to upload " + file.getOriginalFilename() + "!";
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(message);
        }
    }

    @GetMapping("/download")
    public void downloadFile(HttpServletResponse response){
        // 다운로드할 파일 경로 지정
        Path filePath = Paths.get("/Users/minji/Desktop/temp/cat.jpg");

        // 응답의 콘텐츠 타입 지정. 이미지 파일인 JPEG 파일임..
        response.setContentType("image/jpeg");

        try {
            // 지정된 파일의 입력 스트림 생성
            InputStream inputStream = Files.newInputStream(filePath);

            // 입력스트림에서 읽은 데이터를, 출력스트림에 복사하여, 클라이언트에게 전송
            StreamUtils.copy(inputStream, response.getOutputStream());

            // 버퍼를 비워, 응답을 클라이언트에게 전송
            response.flushBuffer();
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}

