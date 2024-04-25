package org.day30;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GroupingTest {
    public static void main(String[] args) {
        List<Member> memberList = Arrays.asList(
                new Member("minjiki2", 23, Member.FEMALE),
                new Member("minjiki3", 24, Member.MALE),
                new Member("minjiki4", 26, Member.FEMALE),
                new Member("minjiki5", 27, Member.MALE)
        );

        Map<Integer, List<Member>> mapBySex = memberList.stream().
                collect(Collectors.groupingBy(Member::getSex));

        System.out.println("남자 ");
        mapBySex.get(Member.MALE).stream().forEach(member -> System.out.println(member));

        System.out.println("여자 ");
        mapBySex.get(Member.FEMALE).stream().forEach(member -> System.out.println(member));
    }
}
