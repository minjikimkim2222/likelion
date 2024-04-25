package org.day30.실습문제;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class Employee {
    private String name;
    private String department;
    private int salary;

    // constructor

    public Employee(String name, String department, int salary) {
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    // getters

    public String getName() {
        return name;
    }

    public String getDepartment() {
        return department;
    }

    public int getSalary() {
        return salary;
    }
}
public class Ex04 {
    public static void main(String[] args) {
        // 직원 관리 - 직원 객체 리스트에서,
        // 각 부서(department)별로 평균 급여를 계산하시오.

        List<Employee> employees = Arrays.asList(
                new Employee("Alice", "HR", 3000),
                new Employee("Bob", "HR", 2000),
                new Employee("Charlie", "Engineering", 5000),
                new Employee("David", "Engineering", 4000)
        );

        // Key - 부서명, Double - 급여 --> 이렇게 생각해내기! - Collectors.groupingBy()
        Map<String, Double> salaryAver = employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment, Collectors.averagingDouble(Employee::getSalary)));

        salaryAver.forEach((department, average) ->
        {
            System.out.println(department + " : " + average);
        });
    }
}
