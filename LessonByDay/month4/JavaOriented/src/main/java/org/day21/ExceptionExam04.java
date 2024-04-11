package org.day21;

public class ExceptionExam04 {
    public static void 심부름withTryCatch(){
        //  엄마 : A 회사의 두부를 사와라
        System.out.println("심부름 시작 !! ");

        // 1. 예외 직접 처리
        int i = 0;
        try {
            System.out.println(10/i); // A 회사 두부 없음!
        } catch (Exception e){
            System.out.println("내가 알아서 다른 마트로 간다.");
        }

        System.out.println("심부름 완료 !! ");
    }

    public static void 심부름withThrows() throws ArithmeticException{
        //  엄마 : A 회사의 두부를 사와라
        System.out.println("심부름 시작 !! ");

        // 2. 예외 간접 처리 - throws
        int i = 0;
        System.out.println(10/i); // A 회사 두부 없음!

        System.out.println("throws Exception처럼, 엄마에게 전화해, 어떻게 해야 할지 물어본다.");

        System.out.println("심부름 완료 !! ");
    }
    public static void main(String[] args) {
        ExceptionExam04.심부름withTryCatch();

        try {
            ExceptionExam04.심부름withThrows();
        } catch (ArithmeticException e){
            System.out.println("엄마, 두부가 없어요!");
            System.out.println("심부름 완료는 여기에서 출력된다 !");
        }
    }
}
