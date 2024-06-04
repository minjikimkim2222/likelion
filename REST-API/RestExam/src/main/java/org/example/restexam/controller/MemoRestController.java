package org.example.restexam.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

@RestController
@RequestMapping("/api/memos")
public class MemoRestController {
    // 간단하게 DB 말고 메모리
    private final Map<Long, String> memos = new HashMap<>();
    private final AtomicLong counter = new AtomicLong(); // Id값 자동으로 생성하라고..

    @PostMapping
    public ResponseEntity<Long> createMemo(@RequestBody String content){
        Long id = counter.incrementAndGet();
        // 원래라면 서비스에 넘기겠지만..
        memos.put(id, content);
        return ResponseEntity.ok(id); // response 상태는 ok로, response body에는 보내온 id값 확인가능
    }

    @GetMapping("/{id}")
    public ResponseEntity<String> getMemoById(@PathVariable("id") Long id){ // 리턴될 content는 String 타입이니..
        String memo = memos.get(id);

        if (memo == null){
//            return ResponseEntity.notFound().build();
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body("해당 id에 해당하는 memo는 존재하지 않습니다");
        } else {
            return ResponseEntity.ok(memo);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateMemo(@PathVariable Long id, @RequestBody String content){
        String memo = memos.get(id);

        if (memo == null){
            return ResponseEntity.notFound().build();
        } else {
            memos.put(id, content);
            return ResponseEntity.ok("메모 수정 성공 !!");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteMemo(@PathVariable Long id){
        String memo = memos.remove(id);

        if (memo == null){ // 삭제할 메모가 없음..
            return ResponseEntity.notFound().build();
        }
        else {
            return ResponseEntity.ok("메모 삭제 성공 !!");
        }
    }
}
