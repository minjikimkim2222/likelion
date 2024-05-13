package org.example.bean_lifecycle;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class MyBean implements InitializingBean, DisposableBean {

    // 디폴트생성자
    public MyBean(){
        System.out.println("MyBean 생성자 호출 !!");
    }

    // implements - override
    @Override
    public void destroy() throws Exception {
        System.out.println("DisposableBean의 destroy 메서드 호출...");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("InitializingBean의 afterPropertiesSet 메서드 호출...");
    }

    // @PostConstruct, @PreDestory
    @PostConstruct
    public void postConsturuct(){
        System.out.println("@PostConstruct 메서드 호출...");
    }

    @PreDestroy
    public void preDestroy(){
        System.out.println("@PreDestroy 메서드 호출...");
    }

    // 사용자정의 init(), cleanup() 메서드 호출
    public void init(){
        System.out.println("사용자 정의 init 메서드 호출...");
    }

    public void cleanup(){
        System.out.println("사용자 정의 cleanup 메서드 호출...");
    }
}
