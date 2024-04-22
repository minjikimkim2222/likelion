package org.day27.Echo_exceptionHandling;

import org.w3c.dom.ls.LSOutput;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.*;
public class EchoServer {
    // try-catch문을 추가한 echo 서버
    public static void main(String[] args) { // try - catch ; 자동 리소스 닫기 이용
        int portNumber = 9999;

        try (ServerSocket serverSocket = new ServerSocket(portNumber);
             Socket clientSocket = serverSocket.accept();
             // 쓸 때는 PrintWriter, 읽을 때는 BufferedReader가 편하다!
             BufferedReader br = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
             PrintWriter pw = new PrintWriter(clientSocket.getOutputStream(), true);
                // PrintWriter는 파일에 쓸 때 flush를 해줘야 써진다.
                // 두번째 인자에 true를 넣으면, 서버에서 쓴 다음에 자동으로 flush해준다는 의미임!
        ) {

            String inputLine = null;
            while ((inputLine = br.readLine()) != null) {
                System.out.println(inputLine);
                // 클라이언트로부터 받은 메세지를, 서버에서 다시 클라이언트에게 보낸다 (echo)
                pw.println("server::: " + inputLine);
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
