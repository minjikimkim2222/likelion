package org.example.jdbc01;

import lombok.*;

// 의존성 추가할 때, lombok 추가 !!
// -- @AllArgsConstructor - public User(id,name,email) {} 생성자와 똑같은 역할
// -- @Getter - 각 멤버변수에 대응되는 getter과 똑같은 역할
// -- @ToString, @Setter
// -- @NoArgsConstructor - 디폴트 생성자..
@AllArgsConstructor
@Getter
@ToString
@NoArgsConstructor
@Setter
public class User {
    private Long id;
    private String name;
    private String email;


}
