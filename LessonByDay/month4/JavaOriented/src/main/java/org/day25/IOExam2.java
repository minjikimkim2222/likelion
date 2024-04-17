package org.day25;

import java.io.*;

public class IOExam2 {
    public static void main(String[] args) throws Exception{
        // 키보드로부터 한줄씩 입력받아서 콘솔에 출력하고 싶다

        // 키보드 System.in
        // '한줄씩' 읽기 위해서 BufferedReader

        System.out.println("키보드에 문자를 입력해주세요 : ");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            // 데코 클래스의 BufferedReader클래스는 매개변수로 Reader를 필요로 하지만,
            // System.in의 타입은 InputStream이다
            // 이렇게 서로 다른 타입을 연결지어주는 역할 - InputStreamReader (extends Reader)
        // 파일로부터 읽어들이기
        BufferedReader br2 = new BufferedReader(new FileReader("a.txt"));
            // FileReader로 데코 클래스와 주인공 클래스 연결지음!
        String str = br.readLine();
        System.out.println("읽어내겠습니다.");
//        System.out.println(str);
        System.out.println(br2.readLine());
    }
}
