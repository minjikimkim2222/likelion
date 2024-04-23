package org.day27.UDP_echo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class UDPEchoClient {
    // UDPEchoServer와 거의 비슷
    public static void main(String[] args) {
        try(BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));) {
            // 1. 클라이언트에서 사용할 DatagramSocket 생성
            DatagramSocket clientSocket = new DatagramSocket();

            // 2. 서버의 IP 주소 및 포트 설정
            InetAddress inetAddress = InetAddress.getByName("localhost");
            byte[] sendData;
            byte[] receiveData = new byte[1024];

            // 3. 키보드로 입력받아서 값을 서버로 보낸다.
            System.out.println("서버로 보낸 메세지를 입력해주세요!");
            String msg = keyboard.readLine();

            // 4. 서버로 데이터 보내기
            DatagramPacket sendPacket = new DatagramPacket(msg.getBytes(), msg.getBytes().length, inetAddress, 8888);
            clientSocket.send(sendPacket);

            // 5. 서버로부터 응답 받기
            DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
            clientSocket.receive(receivePacket);
                // 받은 패킷에서 사용할 String의 메세지를 뽑아온다.
            String receiveMessage = new String(receivePacket.getData());
            System.out.println("FROM server : " + receiveMessage);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
