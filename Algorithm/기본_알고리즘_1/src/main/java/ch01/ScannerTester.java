package ch01;

public class ScannerTester {
    public static void main(String[] args) {
        String str = "12345";
        String str2 = "false";
        boolean isTrue;

        int num = Integer.parseInt(str);
        isTrue = Boolean.parseBoolean(str2);

        if (isTrue){
            System.out.println("it is true");
        }
        else {
            System.out.println("it is false");
        }

        System.out.println("num : " + num);
    }
}
