package org.example.message2;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(ServiceConfig.class)
public class MainConfig {
    // ServiceConfig에 있는 설정을 import를 통해 불러올 수 있다.
    // 추가적인 설정이 있다면 여기에 !!
    MainConfig(){
        System.out.println("MainConfig 생성 !!");
    }
}
