package ch02;

import java.time.LocalDate;
import java.time.LocalTime;

public class CafeRun {
    public static void main(String[] args) {
        Cafe cafe = new Cafe();

        cafe.setCoffeeName("아메리카노");
        cafe.setDesertName("당근 케이크 존맛탱");
        cafe.setOpenTime(LocalTime.of(9,30));
        cafe.setClosedTime(LocalTime.of(21, 30));

        Cafe cafe2 = new Cafe("아이스티", "햅쌀와플", LocalTime.of(11,30), LocalTime.of(21, 0));

        System.out.println("cafe 1 - 베이커 리 - 정보 출력 >>>> ");
        cafe.printCafeInfo();

        System.out.println("cafe 2 - 카페인 중독 - 정보 출력 >>>>");
        cafe2.printCafeInfo();
    }
}
