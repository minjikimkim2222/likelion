package org.day25;

import java.io.*;

public class DataTypeIoExam {
    public static void main(String[] args) {
        // 입출력되는 데이터는 모두 바이트거나 캐릭터로 전송되는... 이것을
        // 자바의 데이터타입으로 읽고 쓰고 싶다. // DataInputStream
        try {
            DataOutputStream dos = new DataOutputStream(new FileOutputStream("data.bin"));
            DataInputStream dis = new DataInputStream(new FileInputStream("data.bin"));

            // data write
            dos.writeInt(23);
            dos.writeDouble(23.2);
            dos.writeBoolean(false);
            dos.writeUTF("hello, minjiki2");

            // data read
            System.out.println(dis.readInt());
            System.out.println(dis.readDouble());
            System.out.println(dis.readBoolean());
            System.out.println(dis.readUTF());

        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
