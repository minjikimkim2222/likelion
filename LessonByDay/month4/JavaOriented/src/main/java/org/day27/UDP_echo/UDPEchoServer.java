package org.day27.UDP_echo;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class UDPEchoServer {
    public static void main(String[] args) {
        // 1. UDP 통신 특정 port에 DatagramSocket 생성
        try {
            DatagramSocket datagramSocket = new DatagramSocket(8888);

            while (true){
                byte[] receiveData = new byte[1024]; // 받을 데이터
                byte[] sendData; // 보낼 데이터

                // 2. 클라이언트로부터 데이터를 받기 위한 DatagramPacket 생성
                DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length); // 받을 데이터의 바이트 배열과 그 배열의 크기
                datagramSocket.receive(receivePacket);

                String message = new String(receivePacket.getData()).trim(); // 받은 바이트 배열을 스트링으로
                    // 사용자로부터 값을 받을 때는, 사용자가 의도치 않게 공백을 같이 보낼 수 있으니, trim 함수 추가해줘야 함.

                // 3. 클라이언트 정보
                InetAddress clientAddress = receivePacket.getAddress();
                int port = receivePacket.getPort();

                // 4. 클라이언트한테 데이터 보내기
                sendData = message.getBytes();
                DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, clientAddress, port);
                datagramSocket.send(sendPacket);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}
