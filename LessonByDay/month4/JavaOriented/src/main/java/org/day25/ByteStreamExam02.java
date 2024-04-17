package org.day25;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class ByteStreamExam02 {
    // read하는 FileInputStream과 write하는 FileOutputStream은 Closeable 인터페이스를 implements하고 있기 때문에!!
    // try 코드 안에서 read하고 write하면, 컴파일러가 finally에서 Closeable 인터페이스를 이용해 자동으로 리소스를 close시켜준다!
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
        }
    }
}
