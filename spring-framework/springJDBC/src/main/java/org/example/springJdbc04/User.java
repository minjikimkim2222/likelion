package org.example.springJdbc04;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@ToString
@Getter
public class User {
    private Long id;
    private String name;
    private String email;
}
