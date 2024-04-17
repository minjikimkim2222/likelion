package org.day25;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class DataOutExam {
    public static void main(String[] args) {
        // 원시데이터타입으로 파일에 쓰고 싶다.
        try {
            FileOutputStream fos = new FileOutputStream("data.txt");
            DataOutputStream dos = new DataOutputStream(fos);

            dos.writeBoolean(true);
            dos.writeByte(Byte.MIN_VALUE);
            dos.writeChar('a');
            dos.writeDouble(1.1);


        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
