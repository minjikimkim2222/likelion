package org.example.springDataJdbc01;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.util.Optional;

@SpringBootApplication
public class MainApplication {
    public static void main(String[] args) {
        SpringApplication.run(MainApplication.class, args);

        // CommandLineRunner에서 실행코드 작성..
    }

    @Bean
    public CommandLineRunner demo(BookRepository bookRepository){
        return new CommandLineRunner() {
            @Override
            public void run(String... args) throws Exception {
                // select TEST - 기본제공 메서드
                Iterable<Book> books = bookRepository.findAll();
                for (Book book : books){
                    System.out.println(book);
                }

                // findById TEST - 기본제공 메서드
                Book bookById = bookRepository.findById(8).get();
                System.out.println(bookById);

                // save TEST - 기본제공 메서드
                bookRepository.save(new Book("saveTEST", "saveAuthor", LocalDate.now()));

                // deletebyId TEST - 기본제공 메서드
                bookRepository.deleteById(12);

                // findByName TEST - 커스텀 메서드
                Book book = bookRepository.findByTitle("The Great Gatsby");
                System.out.println("커스텀 메서드 테스트 !! " + book);

                // findByAuthor TEST - 커스텀 메서드
                Book book2 = bookRepository.findByAuthor("Harper Lee");
                System.out.println("커스텀 메서드 테스트 !! 2" + book2);
            }
        };
    }
}
