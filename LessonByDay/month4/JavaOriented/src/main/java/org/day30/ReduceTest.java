package org.day30;

import java.util.Arrays;
import java.util.List;

public class ReduceTest {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1,2,3,4,5);

        Integer result = numbers.stream().reduce(0, (a,b) -> a+b);

        System.out.println(Integer.valueOf(result));

        // Member test
//        List<Member> memberList = Arrays.asList(new Member("minjiki2", 100),
//                new Member("lee", 80),
//                new Member("park", 90),
//                new Member("choi", 70)
//        );
//
//        // Member들의 score의 총합
//        int memberScoreSum = memberList.stream().mapToInt(member -> member.getScore()).sum();
//
//        // reducer 활용
//        int memberScoreSumByReduce = memberList.stream().mapToInt(Member::getScore).reduce(0, (a,b) -> a+b);
//
//        System.out.println(memberScoreSum);
//        System.out.println(memberScoreSumByReduce);

        //
    }
}
