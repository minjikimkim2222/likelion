package org.day30.실습문제;

import java.util.Arrays;
import java.util.List;

class Student {
    private String name;
    private int score;

    public Student(String name, int score) {
        this.name = name;
        this.score = score;
    }

    // getters

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", score='" + score + '\'' +
                '}';
    }
}
public class EX03 {
    public static void main(String[] args) {
        // 학생 성적 처리
        List<Student> students = Arrays.asList(
                new Student("Alice", 82),
                new Student("Bob", 90),
                new Student("Charlie", 72),
                new Student("David", 76)
        );

        // mapped으로 각 student의 name만 가져와야 하는데 걔를 빼먹었군!
        students.stream().
                filter(str -> str.getScore() >= 80)
                .map(str -> str.getName())
                .sorted().forEach(s -> System.out.println(s));

    }
}
