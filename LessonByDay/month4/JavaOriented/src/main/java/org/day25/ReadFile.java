package org.day25;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class ReadFile {
    public static void main(String[] args) throws Exception{

        FileInputStream fis = new FileInputStream("a.txt");
        FileOutputStream fout = new FileOutputStream("b.txt");

        int n; // read된 바이트 수만큼 리턴됨
        byte[] bytes = new byte[1024];
        int cnt = 0; // 연산의 횟수

        // 1. read(byte[]) 함수 - 파일(fis)에서 데이터를 '한번에' 읽어, 바이트 배열에 저장하는 함수 (cnt == 1)
        while ((n = fis.read(bytes)) != -1){ // EOF(end of file; 파일의 끝) == -1
            cnt++;
            String str = new String(bytes); // bytes 배열 전체를 문자열로 변환
            System.out.println(str);
            fout.write(bytes);
            // write(byte[] b) - bytes배열에 있는 데이터를 fout 스트림의 파일(b.txt)에 쓰는 함수
        }
        System.out.println("cnt : " + cnt); // cnt : 1

        // 2. bytes 배열이 아닌, byte 1개 1개씩 읽는 함수
        cnt = 0;
        while ((n = fis.read()) != -1){ // EOF(end of file; 파일의 끝) == -1
            System.out.println((char)n);
            // read(byte[]) 함수 리턴값 : 읽어들인 바이트 수
            // read() 함수 리턴값 : 읽은 바이트에 대응되는 정수값
                // ex) 파일에 'Hello' 내용이 들어있다면,
                // fis.read() 첫번째 호출 시 'H'에 해당하는 정수값 리턴, 두번째 호출 시 'e'에 해당하는 정수값 리턴..
            cnt++;
        }
        System.out.println("cnt : " + cnt); // cnt : 4
        fout.close();
        fis.close();
    }
}
