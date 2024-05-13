package org.example.bean_lifecycle;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfig {
    // MyBean을 Bean으로 등록하고,
    // 사용자가 정의한 초기화 및 소멸 메서드를 지정해준다!!
    //  -- (알려줘야지.. 얘는 MyBean.java에서 안 알려줬었음..)
    @Bean(initMethod = "init", destroyMethod = "cleanup")
    public MyBean myBean(){
        return new MyBean();
    }
}
