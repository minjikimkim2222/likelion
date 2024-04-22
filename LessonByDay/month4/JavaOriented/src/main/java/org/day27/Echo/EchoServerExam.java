package org.day27.Echo;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServerExam {
    // 에코 서버 구현
    public static void main(String[] args) throws Exception{
        //1. ServerSocket 생성 - '특정 포트에서' 클라이언트의 연결요청을 기다리기 위한 객체
        int portNumber = 1234;
        ServerSocket server = new ServerSocket(1234);
        System.out.println("서버가 준비되었습니다.");

        // 2. 클라이언트 연결 수락
        Socket sock = server.accept(); // accept을 통해, '연결된 클라이언트'의 소켓을 얻어올 수 있다!
        System.out.println(sock.getInetAddress().getHostName() + "와 서버 소켓이 연결되었습니다.");

        // 3. 데이터를 읽고 쓰기
            // 클라이언트로부터 데이터를 읽기 위한 InputStream, 데이터를 클라이언트로부터 보내기 위한 OutputStream
            // 소켓으로부터 '스트림'을 얻어낼 수 있다!

        // 3-1. 입력통로 - 클라이언트로부터 받은 입력을, 서버에서는 읽는다.
        InputStream in = sock.getInputStream();
        BufferedReader br = new BufferedReader(new InputStreamReader(in));

        // 3-2. 출력통로 - 서버에서 write할 메세지는, 클라이언트의 OutputStream으로 보낸다.
        OutputStream out = sock.getOutputStream();
        PrintWriter pw = new PrintWriter(new OutputStreamWriter(out));

        String line = null;

        while ((line = br.readLine()) != null) {
            System.out.println("클라이언트에서 받은 메세지 : " + line);

            // 클라이언트가 보낸 메세지를 다시 클라이언트에 그대로 보낸다!
            pw.println(line);
            pw.flush();
        }

        // 4. 연결 종료
        pw.close();
        in.close();
        out.close();
        sock.close();
    }
}
