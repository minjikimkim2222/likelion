package org.day21;

public class ExceptionExam01 {
    public static void main(String[] args) {
        int[] iarr = {1,3,4,5,6};

        try {
            int result = 10/0;
            System.out.println(iarr[5]);

            System.out.println("거울을 본다.");
//        } catch (ArrayIndexOutOfBoundsException e) {
//            //System.out.println(iarr[0]);
//            System.out.println("Array, e : " + e);
//            System.out.println("Array, e.message : " + e.getMessage());
        } catch (Exception e){
            e.printStackTrace(); // 예외가 어디에서 발생했는지 알려주는 메서드
        }

//        System.out.println("예외 발생 이후, 실행될 다음 문장 1");
//        System.out.println("다음 문장 2");
//        System.out.println("다음 문장 3");
//        System.out.println("!! end !!");
    }
}
