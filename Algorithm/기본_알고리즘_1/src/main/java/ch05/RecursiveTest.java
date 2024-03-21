package ch05;

public class RecursiveTest {

    // 5 4 3 2 1 출력
    public static void recursive(int n){
        if (n == 0){
            return ;
        }
        else {
            System.out.println(n);
            recursive(n-1);
        }

    }

    public static void main(String[] args) {
        recursive(5);
    }
}
