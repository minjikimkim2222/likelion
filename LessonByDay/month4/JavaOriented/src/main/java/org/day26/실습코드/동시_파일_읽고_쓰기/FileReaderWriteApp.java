package org.day26.실습코드.동시_파일_읽고_쓰기;

/*
    목표
        하나의 스레드가 파일에서 데이터를 읽는 동안, 다른 스레드가 다른 파일에 데이터를 쓰는 작업을 동시 수행

    동기화
        각 스레드가 서로 다른 파일을 다루기 때문에, 사용자 입력과 파일 출력 간의 동기화를 고려할 필요가 없다.

    예상결과
        하나의 스레드가 입력파일(input.text)에서 데이터를 읽어 콘솔에 출력하고,
        동시에 다른 스레드에서 사용자의 입력을 받아 출력 파일(output.text)에 데이터를 쓰게 된다!
        서로 간섭없이 독립적인 쓰레드 공간에서 실행된다.

    추가
        FileWriterTask 기능 추가
         -> 1번 정수를 입력받으면, 엔터 전까지 입력된 문자열을 파일(output.text)에 쓰고,
         -> 2번 정수를 입력받으면, "end" 문자열이 입력될 때까지 입력된 문자열을 파일(output.text)에 쓰도록 한다
 */

import java.io.*;
import java.util.Scanner;

class FileReaderTask extends Thread{ // 지정된 파일(input.text)에서 '텍스트' 데이터를 읽고, 콘솔에 출력
    private String fileName;

    public FileReaderTask(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public void run() {
        // 쓰레드가 할 일
        try {
            BufferedReader br = new BufferedReader(new FileReader(fileName));
            String inputString = null;

            System.out.println("input text의 내용을 읽어내겠습니다.");
            while ((inputString = br.readLine())!= null){
                System.out.println(inputString);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

class FileWriterTask extends Thread { // 사용자(System.in)로부터 입력받은 데이터를, 파일에 쓰는(output.text) 작업

    private String fileName;
    private int choice; // 사용자 선택을 저장할 변수

    public FileWriterTask(String fileName, int choice) {
        this.fileName = fileName;
        this.choice = choice;
    }

    @Override
    public void run() {
        // 쓰레드가 할 일
        // 사용자(System.in)로부터 입력받은 데이터를, 파일에 쓰는(output.text) 작업

        String inputString = null;

        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 키보드의 내용을 읽어올 것임.
            BufferedWriter bw = new BufferedWriter(new FileWriter(fileName));
            Scanner sc= new Scanner(System.in);

            System.out.println("사용자로부터 입력을 기다리고 있습니다...");

            if (choice == 1){
                System.out.println("엔터 전까지 입력한 내용을 파일에 쓸 것입니다.");
                inputString = br.readLine(); // 개행 전까지 키보드로부터 입력받는다.
                bw.write(inputString);
                System.out.println("파일에 입력 내용을 성공적으로 기록했습니다.");
            } else if (choice == 2){
                while (true) {
                    System.out.println("'end' 입력 시, 입력이 종료됩니다.");
                    String str = sc.nextLine();

                    if (str.equals("end")){
                        System.out.println("입력을 종료합니다!");
                        break ;
                    }
                    bw.write(str);
                    bw.write('\n');
                }
            }

            bw.close(); // resource를 닫아야 제대로 파일에 쓰였다!!

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
public class FileReaderWriteApp {
    public static void main(String[] args) {
        String inputFileName = "src/main/java/org/day26/실습코드/동시_파일_읽고_쓰기/input.text";
        String outputFileName = "src/main/java/org/day26/실습코드/동시_파일_읽고_쓰기/output.text";

        FileReaderTask fileReaderThread = new FileReaderTask(inputFileName);
        FileWriterTask fileWriterThread = new FileWriterTask(outputFileName, 2);

        fileReaderThread.start();
        fileWriterThread.start();
    }
}
