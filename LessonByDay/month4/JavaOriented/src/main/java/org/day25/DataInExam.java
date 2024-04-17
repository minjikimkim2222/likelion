package org.day25;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class DataInExam {
    public static void main(String[] args) {
        try {
            DataInputStream dis = new DataInputStream(new FileInputStream("data.txt"));

            boolean b = dis.readBoolean();
            System.out.println(b);
            System.out.println(dis.readByte());
            System.out.println(dis.readChar());
            System.out.println(dis.readDouble());
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
