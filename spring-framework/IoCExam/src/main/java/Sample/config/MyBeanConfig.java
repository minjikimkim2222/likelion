package Sample.config;

import Sample.bean.MyBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Scope;

@ComponentScan(basePackages = "sample")
public class MyBeanConfig {
    // <bean id="myBean" class="sample.MyBean"/> -- xml 파일 형식
        // 메서드 형식으로 빈 설정
        // 빈타입 빈id {객체 생성}
        // 빈 여러개 등록할 때는 빈 id가 달라야 해요..
//    @Bean // 어노테이션으로 Bean을 알려주기
//    public MyBean myBean(){ // bean id - "myBean"
//        return new MyBean();
//    }

    @Bean // 어노테이션으로 Bean을 알려주기
    public MyBean myBean2(){ // bean id - "myBean"
        return new MyBean();
    }

    @Bean
    @Scope("prototype")
    public MyBean myBean3(){ // bean id - "myBean"
        return new MyBean();
    }
}
