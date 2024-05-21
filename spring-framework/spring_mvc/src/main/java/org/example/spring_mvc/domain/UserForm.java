package org.example.spring_mvc.domain;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class UserForm {
    @NotEmpty(message = "username은 공백을 허용하지 않습니다.")
    @Size(min = 4, max = 20, message = "username은 4자 ~ 20자 까지만 허용합니다.")
    private String username;

    @NotEmpty(message = "password은 공백을 허용하지 않습니다.")
    @Size(min = 6, message = "password는 6자 이상이어야 합니다.")
    private String password;
}
