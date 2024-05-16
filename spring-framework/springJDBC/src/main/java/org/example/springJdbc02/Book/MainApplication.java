package org.example.springJdbc02.Book;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;

@SpringBootApplication
public class MainApplication {
    public static void main(String[] args) {
        SpringApplication.run(MainApplication.class, args);
        // 실제 실행은 CommandLineRunner에서..
    }

    @Bean
    public CommandLineRunner demo(BookDao bookDao){
        return new CommandLineRunner() {
            @Override
            public void run(String... args) throws Exception {
                // 예외
                try {
                    //bookDao.createAndUpdateBook("minjiki2","minjiki2-author", "minjiki2-newAuthor", LocalDate.now());
                    bookDao.createAndUpdateBook("minjiki2","minjiki2-author", "error-minjiki2-newAuthor", LocalDate.now());
                } catch (Exception e){
                    System.out.println(e.getMessage());
                }


            }
        };
    }
}
