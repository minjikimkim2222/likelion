package Sample.config;

import Sample.bean.Book;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;


@ComponentScan(basePackages = "sample.bean")
public class BookConfig {
//    @Bean
//    public Book bookBean1(){
//        return new Book();
//    }

}
