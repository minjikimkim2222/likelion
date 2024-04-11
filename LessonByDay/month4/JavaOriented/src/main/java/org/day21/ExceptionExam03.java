package org.day21;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class ExceptionExam03 {
    public static void main(String[] args) throws FileNotFoundException {
        // 예외종류 2가지
        // 실행 시 체크하는 예외 (Runtime exception)
        // 컴파일 시 체크하는 예외(checked Exception)

        // 예외처리방법 2가지
        // 1. try ~ catch : 직접 예외 처리
        // 2. throws : 다른 클래스에게 예외처리 떠넘기는 방법

        // 이 코드는 throws 키워드로 예외처리 떠넘기기
        // 쉬운 예시를 든 거고, main에서는 주로 try ~ catch문을 이용할 것
        FileInputStream file = new FileInputStream("abc");
    }
}
