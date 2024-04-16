package org.day24.실습코드.사원_관리_시스템;

import org.day24.실습코드.사원_관리_시스템.Employee;

import java.util.HashSet;

public class EmployeeManager {
    // employee(사원)의 정보를 추가,삭제,검색할 수 있는 기능 구현 클래스
    // **중복된 사원 정보는 추가하지 않는다** -> 중복 X, 유일 요소 O -> HashSet 자료구조
    private HashSet<Employee> employeeHashSet;


    public EmployeeManager() { // HashSet 초기화
        employeeHashSet = new HashSet<>();
    }

    public void addEmployee(Employee employee){
        employeeHashSet.add(employee);
    }

    public void removeEmployee(Employee employee){
        if (employeeHashSet.remove(employee) == false){
            System.out.println("해당 직원은 존재하지 않는 직원입니다.");
            return ;
        }
        System.out.print("id : " + employee.getId() + " ,name : " + employee.getName());
        System.out.println(" 해당 사원의 정보를 삭제합니다.");
        employeeHashSet.remove(employee);
    }

    public void findEmployee(String id){
        for (Employee e : employeeHashSet){
            if (e.getId().equals(id)){
                System.out.println(e.getName() + " 사원 정보 검색에 성공했습니다!");
                return ;
            }
        }
        System.out.println("해당 사원은 존재하지 않습니다.");

    }

}
