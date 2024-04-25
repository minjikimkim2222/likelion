package org.day30.실습문제;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class Temperature {
    private String city;
    private int maxTemp;

    public Temperature(String city, int maxTemp) {
        this.city = city;
        this.maxTemp = maxTemp;
    }

    public String getCity() {
        return city;
    }

    public int getMaxTemp() {
        return maxTemp;
    }
}
public class Ex07 {
    public static void main(String[] args) {
        // 도시별 최고 온도 기록 - 각 도시의 최고온도
        List<Temperature> temperatures = Arrays.asList(
                new Temperature("Seoul", 33),
                new Temperature("New York", 30),
                new Temperature("Seoul", 34),
                new Temperature("New York", 28)
        );

        // Key - String(도시), value - Integer (최고 온도)
        Map<String, Integer> result = temperatures.stream().
                    // toMap (Collectors 기능 1 - 컬렉션 요소 수집
                    // Collectors.toMap(요소에서 키를 추출할 함수, 요소에서 값을 추출할 함수)
                    // Collectors.toMap(키 추출 함수, 값 추출 함수, 동일한 요소 충돌 시 값을 어떻게 병합시킬지
                collect(Collectors.toMap(
                                Temperature::getCity,
                                Temperature::getMaxTemp,
                                (a,b) -> a > b ? a : b));

        result.forEach((city, maxTemp) ->
                System.out.println(city + ": " + maxTemp));
    }
}
