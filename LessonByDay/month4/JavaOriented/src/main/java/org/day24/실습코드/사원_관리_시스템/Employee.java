package org.day24.실습코드.사원_관리_시스템;

import java.util.Objects;

public class Employee {
    private String name; // 이름
    private String id; // 아이디
    private String department; // 부서

    public Employee(String name, String id, String department) {
        this.name = name;
        this.id = id;
        this.department = department;
    }

    // get id, name


    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    // id만 같다면, 두 객체가 같다고 판단하게끔 오버라이딩!
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Employee employee)) return false;
        return Objects.equals(id, employee.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
