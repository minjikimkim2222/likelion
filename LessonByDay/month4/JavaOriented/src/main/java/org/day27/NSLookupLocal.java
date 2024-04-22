package org.day27;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class NSLookupLocal {
    public static void main(String[] args) {
        // 1. 로컬 호스트의 IP 주소와 이름 조회
        try {
            InetAddress localAddress = InetAddress.getLocalHost();
            System.out.println(localAddress.getHostAddress());
            System.out.println(localAddress.getHostName());

            System.out.println("byte[] 형식의 ip 주소 변환 :");
            byte[] ip = localAddress.getAddress(); // 호스트의 IP주소를 바이트 배열로 반환

            for (int i = 0; i < ip.length; i++) {
                System.out.println(ip[i] & 0xFF);
                if (i != ip.length - 1)
                    System.out.println(".");
            }
        } catch (UnknownHostException e){
            e.printStackTrace();
        }

        // 2. 특정 호스트의 IP주소 조회
        System.out.println("특정 호스트 조회 테스트");
        try {
            InetAddress address = InetAddress.getByName("www.google.com");
            System.out.println(address.getHostAddress());

        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        }
    }
}
