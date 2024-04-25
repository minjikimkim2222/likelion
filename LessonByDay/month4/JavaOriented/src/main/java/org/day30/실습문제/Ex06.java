package org.day30.실습문제;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class MathStudent {
    private String name;
    private int age;
    private int score;

    public MathStudent(String name, int age, int score) {
        this.name = name;
        this.age = age;
        this.score = score;
    }

    // getters

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public int getScore() {
        return score;
    }
}
public class Ex06 {
    public static void main(String[] args) {
        // 나이대별(10대, 20대) 평균 점수 계산
        List<MathStudent> students = Arrays.asList(
            new MathStudent("Alice", 14, 88),
            new MathStudent("Bob", 23, 82),
            new MathStudent("Charlie", 17, 95),
            new MathStudent("David", 21, 73)
        );

        // Key - Boolean, Value - List<MathStudent> -> 20대(true)인 리스트, 20대 아닌(true)인 리스트 partitioning
        Map<Boolean, List<MathStudent>> partionedStudentByAge = students.stream()
                .collect(Collectors.partitioningBy(student -> student.getAge() >= 20));

        Double twentiesAver = partionedStudentByAge.get(true).stream().
                mapToInt(student -> student.getScore()).average().orElse(0.0);

        Double NottwentiesAver = partionedStudentByAge.get(false).stream().
                mapToInt(student -> student.getScore()).average().orElse(0.0);

        System.out.println("10s : " + NottwentiesAver);
        System.out.println("20s : " + twentiesAver);

        System.out.println("2번째 방법******************* ");
        // Key - Integer(나이대), Double(점수 평균)
        Map<Integer, Double> studentAver = students.stream()
                .collect(Collectors.groupingBy(
                        student -> (student.getAge() / 10) * 10,  // 나이대(10단위)를 기준으로 그룹화
                        Collectors.averagingDouble(MathStudent::getScore)  // 각 그룹의 점수 평균 계산
                ));
        studentAver.forEach((age, aver) ->
                System.out.println(age + "s: " + aver));
    }
}
