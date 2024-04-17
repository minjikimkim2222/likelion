package org.day25;

import java.io.*;

public class SystemIOExam {
    public static void main(String[] args) {
        // 키보드(System.in)로부터 '한 줄 입력'받기 위한 IO 객체를 생성해주세요!
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter br2 = new BufferedWriter(new OutputStreamWriter(System.out));

            System.out.println("문자열을 입력하세요.");
            String userInput = br.readLine(); // '한줄씩' 읽어들이는 readLine 함수
            br2.write(userInput);

            br.close();
            br2.close();
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
