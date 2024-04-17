package org.day25;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class ReadFile {
    public static void main(String[] args) throws Exception{
//        System.out.println(System.getProperty("user.dir"));
        //FileInputStream file = new FileInputStream("src/main/java/org/day25/ReadFile.java");
        FileInputStream file = new FileInputStream("a.txt");
        FileOutputStream fout = new FileOutputStream("b.txt");

        int n; // read된 바이트 수만큼 리턴됨
        byte[] bytes = new byte[1024];
        int cnt = 0; // 연산의 횟수
        // 1. read(byte[]) 함수로, 바이트 배열을 1번에 읽어오는 함수 (cnt == 1)
//        while ((n = file.read(bytes)) != -1){ // EOF(end of file; 파일의 끝) == -1
//            System.out.println((char)n);
//            cnt++;
////            String str = new String(bytes);
////            System.out.println(str);
////            fout.write(bytes);
//        }
//        System.out.println("cnt : " + cnt); // cnt : 1

        // 2. bytes 배열이 아닌, byte 1개 1개씩 읽는 함수
        cnt = 0;
        while ((n = file.read()) != -1){ // EOF(end of file; 파일의 끝) == -1
            System.out.println((char)n);
            cnt++;
        }
        System.out.println("cnt : " + cnt); // cnt : 4
        fout.close();
        file.close();
    }
}
