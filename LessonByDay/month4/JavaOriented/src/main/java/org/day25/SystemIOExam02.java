package org.day25;

import java.io.*;

public class SystemIOExam02 {
    public static void main(String[] args) {
        // -> 한줄 말고 '여러 줄 입력'
        // 1. 키보드로부터 한줄씩 5번 입력받아서
        // 2. 파일에 출력하는 프로그램을 작성해보세요.
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            PrintWriter pw = new PrintWriter("test.txt");

            for (int i = 0; i < 5; i++) {
                System.out.println("문자열을 입력해주세요 : ");
                String str = br.readLine();
                pw.println(str);
            }

            // 문자열 리소스를 닫아줘야, 버퍼에 있던 내용을 출력해줬다.
            br.close();
            pw.close();
        } catch (IOException e){
            e.printStackTrace();
        }

    }
}
