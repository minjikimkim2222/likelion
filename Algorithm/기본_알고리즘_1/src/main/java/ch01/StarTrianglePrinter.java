package ch01;

public class StarTrianglePrinter {
    public static void starTrianglePrinter(int n){
        for (int i = 1; i <= n; i++){
            for (int j = 1; j <= i; j++){
                System.out.print("*");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        StarTrianglePrinter.starTrianglePrinter(3);
        StarTrianglePrinter.starTrianglePrinter(7);
    }
}
