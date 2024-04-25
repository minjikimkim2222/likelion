package org.day30;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GroupingTest {
    public static void main(String[] args) {
        List<Member> memberList = Arrays.asList(
                new Member("minjiki2", 23, Member.FEMALE), // 1
                new Member("minjiki3", 24, Member.MALE), // 0
                new Member("minjiki4", 26, Member.FEMALE),
                new Member("minjiki5", 27, Member.MALE)
        );

        Map<Integer, List<Member>> mapBySex = memberList.stream().
                collect(Collectors.groupingBy(Member::getSex));

        for (Map.Entry<Integer, List<Member>> entry : mapBySex.entrySet()){
            System.out.println("key : " + entry.getKey());
            System.out.println("value : " + entry.getValue());
        }

        System.out.println("남자 ");
        mapBySex.get(Member.MALE).stream().forEach(member -> System.out.println(member));

        System.out.println("여자 ");
        mapBySex.get(Member.FEMALE).stream().forEach(member -> System.out.println(member));

        // 2. 데이터 분할 (Partitioning) - Collectors.partitionBy() 메서드; 해당 메서드는 boolean 반환
        Map<Boolean, List<Member>> partitionedByAge
                = memberList.stream().collect(Collectors.partitioningBy(member -> member.getAge() >= 25));

        System.out.println("boolean true : 25 나이 이상");
        partitionedByAge.get(true).stream().forEach(System.out::println);

        System.out.println("boolean false : 25 나이 이하");
        partitionedByAge.get(false).stream().forEach(System.out::println);

    }
}
