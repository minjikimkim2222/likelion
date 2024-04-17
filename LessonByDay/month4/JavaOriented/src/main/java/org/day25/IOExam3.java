package org.day25;

import java.io.*;

public class IOExam3 {
    public static void main(String[] args) {
        // "test.txt" 파일에서 한줄씩 입력받아서, 입력받은 문자열 뒤에 hi를 추가해서
        // "testhi.txt" 파일에 출력하는 프로그램을 작성해보세요.
        try {
            BufferedReader br = new BufferedReader(new FileReader("test.txt"));
            PrintWriter pw = new PrintWriter("testhi.txt");

            String readString;
            while ((readString = br.readLine()) != null){
                pw.println(readString + ", hi");
            }
            String getString = br.readLine();

            br.close();
            pw.close();
        } catch (IOException e){
            e.printStackTrace();
        }

    }
}
