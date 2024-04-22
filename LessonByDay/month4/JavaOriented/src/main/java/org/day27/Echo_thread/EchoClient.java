package org.day27.Echo_thread;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

// EchoClient는 썼던 거 그대로 쓰면 됨!
public class EchoClient {
    public static void main(String[] args) {
        String localHost = "127.0.0.1";
        int portNumber = 9999;

        try (Socket clientSocket = new Socket(localHost, portNumber);
             PrintWriter pw = new PrintWriter(clientSocket.getOutputStream(), true);
             BufferedReader br = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
             BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));
                ){

            String userInput = null;
            while ((userInput = keyboard.readLine()) != null){
                if (userInput.equalsIgnoreCase("end"))
                    break;
                pw.println(userInput); // 클라이언트, 키보드에서 입력한 문자열을 서버에게 보낸다.
                String echo = br.readLine(); // 서버가 보낸 메세지를 받은 클라이언트
                System.out.println(echo);
            }

        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
