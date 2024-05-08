package com.exam.jdbc;

import java.util.List;

public class DeptDAORun {
    public static void main(String[] args) {
        DeptDAO deptDAO = new DeptDAO();
        DeptDTO deptDTO = new DeptDTO();
        // insert
//        deptDTO.setDeptno(60);
//        deptDTO.setDname("lion");
//        deptDTO.setLoc("대구");
//
//        boolean isAdded = deptDAO.insertDept(deptDTO);
//        if (isAdded)
//            System.out.println("입력성공 !!");
//        else
//            System.out.println("입력 실패 ㅜㅜ");

        // update
        deptDTO.setDeptno(60);
        deptDTO.setDname("edit_lion");
        deptDTO.setLoc("edit_대구2");

        int count = deptDAO.updateDept(deptDTO);
        if (count > 0)
            System.out.println("수정 성공!!");
        else
            System.out.println("수정 실패..");

        // delete test
        deptDAO.deleteDept(60);

        // 한건만 조회 test
        DeptDTO deptDTO2 = deptDAO.selectDeptById(10);
        if (deptDTO2 == null)
            System.out.println("select 실패..");
        else
            System.out.println(deptDTO2);

        // 모든 건수 조회 test
        System.out.println("모든 건수 조회");

        List<DeptDTO> deptList = deptDAO.selectAllDept();

        for (DeptDTO dto : deptList){
            System.out.println(dto);
        }
    }
}
