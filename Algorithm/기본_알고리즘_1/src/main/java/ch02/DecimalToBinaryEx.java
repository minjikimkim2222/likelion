package ch02;

public class DecimalToBinaryEx {
    public static void main(String[] args) {
        int decimal = 29;
        StringBuilder stringBuilder = new StringBuilder();

        while (decimal > 0){
            int remainder = decimal % 2;
            decimal = decimal / 2;

            stringBuilder.append(remainder);
        }
        System.out.println("stringBuilder : " + stringBuilder);

        String reversedString = stringBuilder.reverse().toString();

        System.out.println("최종 2진수 : " + reversedString);
    }
}
