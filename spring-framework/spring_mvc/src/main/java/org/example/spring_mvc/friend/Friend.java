package org.example.spring_mvc.friend;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Friend {
    @NotEmpty(message="id는 공백을 허용하지 않습니다.")
    @Size(min = 4, max = 20, message = "id는 4자 ~ 20자 까지만 허용합니다.")
    private String id;

    @NotEmpty(message="name은 공백을 허용하지 않습니다.")
    private String name;

    @NotEmpty(message="email는 공백을 허용하지 않습니다.")
    private String email;

}
