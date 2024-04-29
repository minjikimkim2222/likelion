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
    private int currentRoomId; // 현재 사용자가 위치한 채팅방 ID 저장 변수
    private static List<String> temporaryUserList = new ArrayList<>(); // 임시 사용자 리스트; // 아이디 중복 여부 체크 저장 변수

    public UserManager(Socket clientSocket) {
        this.clientSocket = clientSocket;
        this.rooms = ChatServer.getRooms();

        // 연결된 클라이언트로부터 사용자의 닉네임을 받아, 메세지와 사용자 IP주소 출력
        // 여기서 입출력통로인 in, out 이 초기화되었다!
        try {
            in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            out = new PrintWriter(clientSocket.getOutputStream(), true);

            // 중복된 닉네임 확인
            String inputNickName = null;
            while (true) {
                inputNickName = in.readLine();

                if (isNicknameAlreadyUsed(inputNickName)) {
                    out.println("이미 사용중인 닉네임입니다. 다른 닉네임을 선택해주세요!");
                } else {
                    // id가 유일하다!
                    break;
                }
            }

            temporaryUserList.add(inputNickName);

            this.nickName = inputNickName;
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
                        if (rooms.isEmpty()) {
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

                        System.out.println("방 번호 [" + roomId + "]가 생성되었습니다.");
                    }
                } else if (command.equalsIgnoreCase("/join")) { // 방 입장
                    int roomId = Integer.parseInt(words[1]); // 방 번호

                    synchronized (rooms) {
                        if (rooms.containsKey(roomId)) {
                            // 특정 사용자가 특정 채팅방에 들어가게 하기
                            // 방에 입장하면, "닉네임이 방에 입장했습니다." 메세지 전달
                            User user = new User(out, nickName);
                            List<User> users = rooms.get(roomId);
                            users.add(user);
                            this.currentRoomId = roomId; // 들어간 방의 roomId를 설정!
                            out.println(nickName + "님이 [ "+ currentRoomId +" ]방에 입장하셨습니다."); // 내 out통로에도 출력해주고
                            sendMessageToCurrentRoom(nickName + "님이 [ "+ currentRoomId +" ]방에 입장하셨습니다.");
                            // 나랑 같은 채팅방 사람들에게도 알리고.. (모든 채팅방 사람들에게 알리는 건 - broadcast 기능)
                        } else {
                            out.println("채팅방 id : " + roomId + "는 존재하지 않습니다.");
                        }
                    }
                }
                else if (command.equalsIgnoreCase("/exit")) {
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
                            String msg = nickName + " 님이 방을 나갔습니다.";
                            out.println(msg);
                            sendMessageToCurrentRoom(msg); // 나뿐만 아니라 나와 같은 채팅방 사람들에게도 알리기..

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
                } else if (command.equalsIgnoreCase("/msg")){
                    String msg = inputLine.substring(5); // "/msg " 제외한 메세지 부분 문자열
                    sendMessageToCurrentRoom(msg);
                } else if (command.equalsIgnoreCase("/broad")){
                    String msg = inputLine.substring(7) ; // "/broad " 제외한 메세지 부분 문자열
                    broadcastMsg(msg);
                } else if (command.equalsIgnoreCase("/whisper")){ // 귓말 기능
                    String to = words[1]; // 귓말 보낼 대상
                    String msg = inputLine.substring(10 + to.length()); // 귓말 보낼 메세지

                    whisper(msg, to);
                }
                else {
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
        out.println("내 채팅방 사람들에게만 메세지 보내기 : /msg");
        out.println("모든 사람들에게 메세지 보내기 : /broad");
        out.println("귓말 보내기 : /whisper [닉네임] [메세지]");
        out.println("방 나가기 : /exit");
        out.println("접속종료 : /bye");
    }

    private void sendMessageToCurrentRoom(String msg){
        // 내가 위치한 채팅방 사람들에게만 메세지 보낼 거다!!!!!
        synchronized (rooms) {
            List<User> users = rooms.get(currentRoomId);

            if (users != null){
                for (User user : users){

                    if (!user.getNickName().equals(nickName)) { // 나 자신에게는 메세지 보내면 안된다.
                        user.sendMessage(msg);
                        user.getOut().flush();
                    }
                }
            } // if문
        }
    }

    private void broadcastMsg(String msg){ // 모든 채팅방에 위치한 유저에게 메세지 보내기
        // test/HashMapEtc.java 테스트 코드 참고
        for (List<User> users : rooms.values()){
            for (User user : users){
                user.sendMessage(msg);
                user.getOut().flush();
            }
        }
    }

    private void whisper(String msg, String to) { // 귓말 기능
        // 예외처리
        // 나자신에게는 귓말 못 보냄
        // 없는 유저에게는 귓말 못 보냄
        // 나랑 '같은' 채팅방에 위치한 유저들에게만, 귓말 보낼 수 있음..

        synchronized (rooms) {
            List<User> users = rooms.get(currentRoomId);

            if (users != null) {
                boolean userFound = false; // 대상 사용자를 찾았는지 여부

                for (User user : users) {
                    if (user.getNickName().equals(nickName)) { // 나 자신에게는 귓말 보내지 않는다.
                        continue;
                    }

                    if (user.getNickName().equals(to)) { // 내가 귓말 보낼 대상자랑 일치한다면...
                        PrintWriter pw = user.getOut();

                        if (pw != null) {
                            pw.println(msg); // 메세지 전송
                            user.getOut().flush();
                            userFound = true;
                            break; // 대상 사용자를 찾았으므로 반복문 종료
                        } else {
                            out.println(to + "닉네임을 가진 유저가 " + currentRoomId + "번 방에 존재하지 않습니다.");
                            return;
                        }
                    }
                } // for문

                if (!userFound) {
                    out.println(to + "닉네임을 가진 유저가 " + currentRoomId + "번 방에 존재하지 않습니다.");
                }
            } else {
                out.println(to + "닉네임을 가진 유저가 " + currentRoomId + "번 방에 존재하지 않습니다.");
            }
        }
    } // whisper

    // 중복된 닉네임 확인해주는 메서드
    private boolean isNicknameAlreadyUsed(String nickName){

        System.out.println("받은 닉네임 : " + nickName);

        for (String str : temporaryUserList){
            if (str.equals(nickName)) {
                System.out.println("현재 str : " + str);
                return true;
            }
        }

        return false; // 중복된 닉네임 없음
    }
}