package org.day24.실습코드.사원_관리_시스템;

import org.day24.실습코드.사원_관리_시스템.Employee;
import org.day24.실습코드.사원_관리_시스템.EmployeeManager;

public class EmployeTest {
    public static void main(String[] args) {
        EmployeeManager manager = new EmployeeManager();

        manager.addEmployee(new Employee("홍길동", "E01", "HR"));
        manager.addEmployee(new Employee("김철수", "E02", "Marketing"));
        manager.addEmployee(new Employee("홍길동", "E01", "HR")); // 중복 추가 시도
            // 이때, Employee 클래스에 equals랑 hashcode를 오버라이드시켜서, 객체의 주소가 아닌 값을 비교할 수 있도록 해준다!

        manager.findEmployee("E01");
        manager.removeEmployee(new Employee("홍길동", "E01", "HR"));
        manager.findEmployee("E01");


    }
}
