package org.day25.실습문제.전화번호부_관리_프로그램;

import java.io.*;

/*  IOExam2.java 코드 참고
    1. 사용자(키보드)로부터 입력을 받은 내용을 (BufferedReader, InputStreamReader)
    2. 파일에 write시킨다. (PrintWriter, FileOutputStream)
    3. write시킨 파일의 내용을 read한다. (BufferedReader, FileReader)

    주의할 점 -> 리소스 쓰고 바로 닫아야, 파일이 잘 read되고 write된다
 */
public class PhoneBook {
    public static void main(String[] args) {
        String filePath = "src/main/java/org/day25/실습문제/전화번호부_관리_프로그램/phonebook.txt";
        String name = null;
        String phoneNumber = null;

        try {
            // 사용자로부터 입력받기
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            PrintWriter pw = new PrintWriter(filePath);

            for (int i = 0; i < 3; i++){
                System.out.println("이름 : ");
                name = br.readLine(); // "홍길동"
                System.out.println("전화번호 : ");
                phoneNumber = br.readLine(); // "010-1234-5678"
                pw.println(name + " " + phoneNumber); // 파일에 지정된 문자열을 쓰고 + 줄바꿈을 추가!
            }

            System.out.println(".. 전화번호가 "+ filePath +"에 저장되었습니다.");

            pw.close();
            // write시킨 파일 read해오기
            BufferedReader br2 = new BufferedReader(new FileReader(filePath));

            System.out.println(filePath +"의 내용은 다음과 같습니다...");

            String readFile = null;
            while ((readFile = br2.readLine()) != null){
                System.out.println(readFile);
            }

            br.close();
            br2.close();
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
