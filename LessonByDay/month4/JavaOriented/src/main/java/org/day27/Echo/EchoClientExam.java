package org.day27.Echo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

public class EchoClientExam {
    public static void main(String[] args) throws Exception{
        // 1. Socket 객체 생성
            // 서버의 IP주소, 포트번호를 사용해 Socket 객체를 생성해, 서버에 연결!
        int portNumber = 1234;
        Socket socket = new Socket("127.0.0.1", 1234);
        System.out.println(portNumber + "포트와 잘 연결되었습니다.");

        // 2. 데이터 읽고 쓰기
            // 데이터를 읽고 쓰기 위해서는 통로인 '스트림' 필요!
        PrintWriter pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));
        BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));

        // 클라이언트가 입력하기 위한 통로
        BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));

        String line = null;
        while ((line = keyboard.readLine()) != null){
            if (line.equalsIgnoreCase("end")) // 대소문자 구분안하는 equals
                break;
            pw.println(line); // 클라이언트가 쓴 메세지를, 서버에게 보낸다.
            pw.flush();

            // 서버에서 메세지 다시 받음
            String echo = br.readLine();
            System.out.println("서버로부터 다시 받은 메세지 : " + echo);
        }

        // 3. 연결 종료
        pw.close();
        br.close();
        keyboard.close();
        socket.close();

    }
}
