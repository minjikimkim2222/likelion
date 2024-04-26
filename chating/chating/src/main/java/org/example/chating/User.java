package org.example.chating;

import java.net.Socket;

class User {
    private Socket socket; // 각 User(클라이언트)에 연결된 소켓 -> 이 소켓이 있어야 I/O 기능 수행 가능!
    private String nickName;

    public User(Socket socket, String nickName) {
        this.socket = socket;
        this.nickName = nickName;
    }

    public Socket getSocket() {
        return socket;
    }

    public String getNickName() {
        return nickName;
    }


}