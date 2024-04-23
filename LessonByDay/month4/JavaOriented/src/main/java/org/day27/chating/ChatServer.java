package org.day27.chating;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

public class ChatServer {
    public static void main(String[] args) {
        int portNumber = 123;
        // 각 clientId(key)로 사용해, 각 클라이언트의 출력스트림(PrintWriter)를 값(value)로 관리할 수 있게끔!
        Map<String, PrintWriter> chatClients = new HashMap<>();

        // 1. 서버 소켓 생성
        try (ServerSocket serverSocket = new ServerSocket(portNumber);) {
            System.out.println("서버가 포트번호 " + portNumber + "에 연결되었습니다.");

            while (true) {
                // 2. accept()를 통해서 소켓을 얻어옴. (여러 개의 클라이언트와 접속할 수 있도록 구현)
                Socket clientSocket = serverSocket.accept();
                // Thread 이용 !!
                // 여러 명의 클라이언트 정보를 기억할 자료구조 -> HashMap
                ChatThread chatThread = new ChatThread(clientSocket, chatClients);
                chatThread.start();
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}

class ChatThread extends Thread {
    // 생성자를 통해서 클라이언트 소켓을 얻어옴
    private Socket clientSocket;
    private String clientId;
    private Map<String, PrintWriter> chatClients; // 다른 클라이언트들에게도 정보를 보내기 위해 해당 hashMap 자료구조 need

    BufferedReader in = null;
    PrintWriter out;
    public ChatThread(Socket clientSocket, Map<String, PrintWriter> chatClients){
        this.clientSocket = clientSocket;
        this.chatClients = chatClients;

        // 클라이언트가 생성될 때, 클라이언트로부터 아이디를 불러오게 하고 싶다.
        try {
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true); // 각 클라이언트에 쓰기 위한 통로
            in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            // Client가 접속하자마자 id를 보낸다는 약속!
            this.clientId = in.readLine();
            // 이때.. 모든 사용자에게 id님이 입장했다라는 정보를 알려줌
            broadcast(clientId + "님이 입장하셨습니다.");
            System.out.println("새로운 사용자의 아이디는 " + clientId + "입니다.");

            // 여러 클라이언트가 put하는 동작이 '동시에' 일어날 수도 !
            synchronized (chatClients) {
                chatClients.put(this.clientId, out);
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        // run
        // 연결된 클라이언트가 메세지를 전송하면, 그 메세지를 읽어서 다른 사용자에게 보내줌.
        String msg = null;

        try {
            while ((msg = in.readLine()) != null){
                if ("/quit".equalsIgnoreCase(msg)) // 클라이언트가 /quit 입력하면 그만!
                    break;
                broadcast(clientId + " : " + msg);
            }
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            synchronized (chatClients){
                chatClients.remove(clientId);
            }
            broadcast(clientId + "님이 채팅에서 나갔습니다.");

            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }

            if (clientSocket != null){
                try {
                    clientSocket.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }

    }

    // 전체 사용자에게 알려주는 메서드
    public void broadcast(String msg){
        for (PrintWriter eachClientOut : this.chatClients.values()){
            eachClientOut.println(msg);
        }
    }
}
