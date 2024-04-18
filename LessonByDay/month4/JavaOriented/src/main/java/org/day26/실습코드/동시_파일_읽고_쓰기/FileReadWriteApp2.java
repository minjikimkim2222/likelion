package org.day26.실습코드.동시_파일_읽고_쓰기;

/*
    목표
        하나의 스레드가 파일에서 데이터를 읽는 동안, 다른 스레드가 '동일한' 파일에 데이터를 쓰는 작업을 동시 수행

    동기화
        동일한 공유자원('input.text')에 동시에 파일을 읽고 쓰기 때문에 동기화 문제를 생각해주어야 한다!!

        동기화 메커니즘 사용
            synchronized 키워드를 사용해 하나의 쓰레드만 접근할 수 있도록 한다!
            -> FileWriterTask 클래스에서 BufferedWriter를 동기화 블럭으로 만들어, 동시에 여러 쓰레드에서 사용하지 못하게 한다 !!

            join으로 한 쓰레드가 다른 쓰레드의 종료를 기다려주게 한다.
            -> join해줘도 동기화 문제를 해결해주지 않으면, 공유 자원에 동시에 접근하게 되어 문제가 발생할 수 있다!
 */

import java.io.*;
import java.util.Scanner;

class FileReaderThread extends Thread {
    private String fileName;

    public FileReaderThread(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public void run() {
        try {
            synchronized (FileReadWriteApp2.lock) { // fileName이 input.text로 동일하니까 동기화 블럭으로 묶어줬다!!
                BufferedReader br = new BufferedReader(new FileReader(fileName));
                String inputString = null;

                System.out.println("input text의 내용을 읽어내겠습니다.");
                while ((inputString = br.readLine()) != null) {
                    System.out.println(inputString);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

class FileWriterThread extends Thread {
    private String fileName;
    private int choice;

    public FileWriterThread(String fileName, int choice) {
        this.fileName = fileName;
        this.choice = choice;
    }

    @Override
    public void run() {
        try {
            synchronized (FileReadWriteApp2.lock) { // fileName이 input.text로 동일하니까 동기화 블럭으로 묶어줬다!!
                BufferedWriter bw = new BufferedWriter(new FileWriter(fileName));
                Scanner sc = new Scanner(System.in);

                System.out.println("사용자로부터 입력을 기다리고 있습니다...");

                if (choice == 1) {
                    System.out.println("엔터 전까지 입력한 내용을 파일에 쓸 것입니다.");
                    String inputString = sc.nextLine(); // 개행 전까지 키보드로부터 입력받는다.
                    bw.write(inputString);
                    System.out.println("파일에 입력 내용을 성공적으로 기록했습니다.");
                } else if (choice == 2) {
                    while (true) {
                        System.out.println("'end' 입력 시, 입력이 종료됩니다.");
                        String str = sc.nextLine();

                        if (str.equals("end")) {
                            System.out.println("입력을 종료합니다!");
                            break;
                        }
                        bw.write(str);
                        bw.newLine();
                    }
                }

                bw.close(); // resource를 닫아야 제대로 파일에 쓰였다!!
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

public class FileReadWriteApp2 {
    public static final Object lock = new Object();

    public static void main(String[] args) {
        String inputFileName = "input.txt";
        String outputFileName = "input.txt";

        // 파일 쓰기를 수행하는 스레드 생성 및 시작
        FileWriterThread fileWriterThread = new FileWriterThread(outputFileName, 2);
        fileWriterThread.start();
        FileReaderThread fileReaderThread = new FileReaderThread(inputFileName);
        fileReaderThread.start();

        try {
            // 파일 쓰기 스레드가 종료할 때까지 대기
            fileWriterThread.join();

            // 파일 읽기를 수행하는 스레드 생성 및 시작
//            FileReaderThread fileReaderThread = new FileReaderThread(inputFileName);
//            fileReaderThread.start();
                // 이 주석의 위치가 보기 좋겠지만 join처리 해주니 상관없다!
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
