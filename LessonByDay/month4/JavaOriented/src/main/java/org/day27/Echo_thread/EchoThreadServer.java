package org.day27.Echo_thread;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoThreadServer {
    public static void main(String[] args) {
        //1. ServerSocket 생성..  -- 1개만 있으면 됨.
        try (ServerSocket serverSocket = new ServerSocket(9999);
        ) {
            while (true) {
                Socket clientSock = serverSocket.accept();  //클라이언트 수만큼 반복!!
                //클라이언트마다 각자 실행 할 수 있도록 만들어야함!!  (쓰레드!!)
                EchoThread echoThread = new EchoThread(clientSock);
                echoThread.start();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class EchoThread extends Thread{
    private Socket socket;
    EchoThread(Socket socket){
        this.socket = socket;
    }
    @Override
    public void run() {
        System.out.println(socket.getInetAddress().getHostAddress() + "로 부터 연결되었습니다.");

        try(PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        ){
            String line = null;
            while((line = in.readLine()) != null){
                System.out.println("클라이언트로 부터 받은 메시지 : "+ line);
                out.println(line);
            }
        }catch (Exception e){
            System.out.println(e);
        } finally {
            try {
                socket.close(); // BufferedReader, PrintWriter는 try문 안에서 자동 리소스 닫기 기능을 사용했으나,
                                // socket은 처리해주지 않았으니, 해당 부분 close시켜줘야 함!
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
