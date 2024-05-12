package Sample.config;

import Sample.bean.Book;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class BookConfig {
    // 메서드 형식으로 빈 설정
    // 빈타입 빈id {객체 설정}
    // 빈 여러 개 등록할 때는 빈 id가 달라야 해요..
    @Bean
    public Book book(){
        return new Book();
    }

    @Bean
    @Scope("prototype")
    public Book bookByPrototype(){
        return new Book();
    }

}
