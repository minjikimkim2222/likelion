package org.day27.chating;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ChatClient {
    public static void main(String[] args) {
        // 아이디가 처음에 입력되게 하기 위해서, args[0]에서 읽어오는 것으로 구현해보자.
        if (args.length != 1){
            System.out.println("사용법 : java ChatClient id");
            System.exit(1); // 프로그램 강제 종료
        }
        int portNumber = 123;
        try(Socket socket = new Socket("127.0.0.1", 123);
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));
                ){
            // 접속되면 clientId를 서버에 보낸다. (서버와의 약속)
            out.println(args[0]);

            // 서버로부터 받은 메세지를 출력하는 것을 Thread로...
            InputThread inputThread = new InputThread(socket, in);
            inputThread.start();


            // 키보드로부터 입력받은 내용을 출력하는 코드
            String msg = null;
            while ((msg = keyboard.readLine()) != null){
                out.println(msg); // 키보드로부터 한줄 받아서 보냄

                if ("./quit".equalsIgnoreCase(msg))
                    break;
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}

class InputThread extends Thread {
    private Socket socket;
    private BufferedReader in;
    public InputThread(Socket socket, BufferedReader in){
        this.socket = socket;
        this.in = in;
    }

    @Override
    public void run() {
        try {
            // 서버가 보내온 메세지를 출력하는 코드
            String msg = null;

            while ((msg = in.readLine()) != null){
                System.out.println(msg);
            }
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            if (in != null){
                try {
                    in.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }

            if (socket != null){
                try {
                    socket.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}