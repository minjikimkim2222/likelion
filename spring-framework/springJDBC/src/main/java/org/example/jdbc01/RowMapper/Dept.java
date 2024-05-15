package org.example.jdbc01.RowMapper;

import lombok.Getter;
import lombok.Setter;

// lombok을 통해 각 멤버변수에 대응하는 getter, setter 쉽게 만들 수 있음..
@Setter
@Getter
public class Dept {
    private int id;
    private String dname;
    private String location;
}
