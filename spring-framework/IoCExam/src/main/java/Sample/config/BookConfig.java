package Sample.config;

import Sample.bean.Book;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BookConfig {
    @Bean
    public Book bookBean1(){
        return new Book();
    }

    @Bean
    public Book bookBean2(){
        return new Book();
    }
}
