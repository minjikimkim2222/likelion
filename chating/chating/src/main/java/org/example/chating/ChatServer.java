package org.example.chating;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.*;

/*
    main 쓰레드
        - 다수의 클라이언트가 접속받는다.

    UserManager 쓰레드
        - 각 연결된 클라이언트와 채팅방 관리를 해주는 쓰레드

 */
public class ChatServer {
    private static Map<Integer, List<User>> rooms = new HashMap<>();

    public static void main(String[] args) {
        try {
            int portNumber = 123;

            ServerSocket serverSocket = new ServerSocket(123);
            System.out.println("서버가 포트번호 : " + portNumber + "에 연결되었습니다.");

            while (true) {
                Socket clientSocket = serverSocket.accept();

                // UserManager 쓰레드 - 각 연결된 클라이언트와 채팅방 관리를 해주는 전반적인 쓰레드
                UserManager userManager = new UserManager(clientSocket);
                userManager.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Map<Integer, List<User>> getRooms() {
        return rooms;
    }
}

class UserManager extends Thread {
    private Socket clientSocket;
    private Map<Integer, List<User>> rooms;
    private String nickName;
    private PrintWriter out = null;
    private BufferedReader in = null;

    public UserManager(Socket clientSocket) {
        this.clientSocket = clientSocket;
        this.rooms = ChatServer.getRooms();

        // 연결된 클라이언트로부터 사용자의 닉네임을 받아, 메세지와 사용자 IP주소 출력
        try {
            in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            out = new PrintWriter(clientSocket.getOutputStream(), true);
            this.nickName = in.readLine();
            System.out.println(nickName + "닉네임의 사용자가 연결했습니다.");
            System.out.println("IP주소 : " + clientSocket.getInetAddress().getHostAddress());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() { // 5가지 명령 처리
        try {
            // 클라이언트에게 명령어 전송
            commandCall();

            // 각각의 명령어 처리 - 클라이언트로부터 문자열 읽어들이기
            String inputLine = null;

            while ((inputLine = in.readLine()) != null) { // socket 닫게 되면 null 반환
                String[] words = inputLine.trim().split(" ");
                String command = words[0];

                if (command.equalsIgnoreCase("/list")) {
                    // 서버는 생성된 모든 방의 목록을 출력한다
                    System.out.println("현재 생성된 모든 방의 목록 : ");

                    synchronized (rooms) { // 각 UserManager 쓰레드별로 접근할 수 있으니, 동기화 처리해주기
                        if (rooms.size() == 0) {
                            System.out.println("현재 존재하는 채팅방은 없습니다.");
                        }

                        for (Integer roomId : rooms.keySet()) {
                            System.out.println("방 번호 : " + roomId);
                        }
                    }
                } else if (command.equalsIgnoreCase("/create")) { // 방 생성
                    synchronized (rooms) {
                        // 새 방 생성
                        int roomId = rooms.size() + 1; // 방 id
                        rooms.put(roomId, new ArrayList<>());

                        // ** 클라이언트를 생성된 새 방에 추가 **
                        User user = new User(clientSocket, nickName);
                        rooms.get(roomId).add(user);

                        System.out.println("방 번호 [" + roomId + "]가 생성되었습니다.");
                    }
                } else if (command.equalsIgnoreCase("/join")) { // 방 입장
                    int roomId = Integer.parseInt(words[1]); // 방 번호

                    synchronized (rooms) {
                        if (rooms.containsKey(roomId)) {
                            // 특정 사용자가 특정 채팅방에 들어가게 하기
                            // 방에 입장하면, "닉네임이 방에 입장했습니다." 메세지 전달
                            User user = new User(clientSocket, nickName);
                            rooms.get(roomId).add(user);
                            out.println(nickName + "님이 방에 입장하셨습니다.");
                        } else {
                            out.println("채팅방 id : " + roomId + "는 존재하지 않습니다.");
                        }
                    }
                } else if (command.equalsIgnoreCase("/exit")) {
                    // "닉네임이 방을 나갔습니다" 메세지와 함께 로비로 이동
                    // 방에 아무도 없다면, 해당 방을 삭제하고 "방 번호 [방번호]가 삭제되었습니다."를 출력
                    synchronized (rooms) {
                        boolean isUserLeftRoom = false; // 사용자가 방을 나갔는지 여부를 저장할 플래그 변수

                        for (List<User> userList : rooms.values()) {
                            Iterator<User> iterator = userList.iterator();

                            while (iterator.hasNext()) {
                                User user = iterator.next();

                                if (user.getNickName().equals(nickName)) {
                                    iterator.remove();
                                    isUserLeftRoom = true;
                                    break;
                                }
                            }
                            if (isUserLeftRoom) break; // 사용자가 이미 나갔으므로, for문 나가야됨
                        } // for

                        if (isUserLeftRoom) {
                            out.println(nickName + "님이 방을 나갔습니다.");
                            // 방이 비어있다면, 방 삭제!! -> Collection removeIf 함수 이용해서 깔끔해짐
                            rooms.entrySet().removeIf(entry -> entry.getValue().isEmpty());
                        } else
                            out.println("현재 방에 입장 중이 아니거나, 해당 " + nickName + " 사용자가 존재하지 않습니다.");
                    } // synchronized
                } else if (command.equalsIgnoreCase("/bye")) { // 접속 종료
                    // 연결 종료하고, 프로그램 종료
                    // 서버도 "ㅇㅇㅇ 닉네임 사용자가 연결을 끊었습니다." sout하고 연결 종료시키기
                    System.out.println(nickName + "닉네임 사용자가 연결을 끊었습니다.");
                    in.close();
                    out.close();
                    clientSocket.close();

                    System.out.println("접속을 종료합니다.");
                    break; // while문 탈출
                } else {
                    System.out.println("알 수 없는 명령어입니다. 다시 입력해주세요");
                    commandCall();
                }

            } // while

            // 모든 명령 끝나고 난 후, 소켓들 close시킬 것
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void commandCall() {
        out.println("방 목록 보기 : /list");
        out.println("방 생성 : /create");
        out.println("방 입장 : /join [방 번호]");
        out.println("방 나가기 : /exit");
        out.println("접속종료 : /bye");
    }
}