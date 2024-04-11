package org.day21;

public class NumberRangeChecker {
    public void checkNumber(int number) {
        // 숫자가 1과 100 사이에 있다고 가정)
        if (number < 1 || number > 100) {
            throw new IllegalArgumentException("숫자는 1과 100 사이에 있어야 합니다: " + number);
        }
    }

    public static void main(String[] args) {
        NumberRangeChecker checker = new NumberRangeChecker();

        try {
            checker.checkNumber(150); // 범위 out!
        } catch (IllegalArgumentException e) {
            System.err.println("오류 발생 : " + e.getMessage());
        }
    }
}
