package org.day25;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class ByteStreamExam {
    // 파일로부터 읽어서 -- 입력 통로가 필요
    // 파일에 쓴다. -- 출력 통로가 필요.
    public static void main(String[] args) {
        FileInputStream in = null;
        FileOutputStream out = null;

        try {
            in = new FileInputStream("src/main/java/org/day25/ReadFile.java");
            out = new FileOutputStream("outputFile.txt"); // 예시로 쓰기 위해 다른 파일명을 사용

            int c;
            while ((c = in.read()) != -1) {
                out.write(c); // read한 바이트수(c)만큼 파일에 write시킨다.
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (in != null) {
                    in.close();
                }
                if (out != null) {
                    out.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}