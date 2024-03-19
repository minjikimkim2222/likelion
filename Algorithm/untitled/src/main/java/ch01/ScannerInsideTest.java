package ch01;

public class ScannerInsideTest {
    public static void main(String[] args) {
        int number = Integer.parseInt(args[0]);

        String str = args[1];

        boolean isTrue = Boolean.parseBoolean(args[2]);

        if (isTrue) {
            System.out.println("it is true");
        }
        else {
            System.out.println("it is false");
        }
    }
}
