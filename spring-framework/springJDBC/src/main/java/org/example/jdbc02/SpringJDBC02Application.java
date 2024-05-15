package org.example.jdbc02;

import org.example.jdbc02.dao.Book;
import org.example.jdbc02.dao.BookDao;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.util.List;

@SpringBootApplication
public class SpringJDBC02Application {
    public static void main(String[] args) {
        SpringApplication.run(SpringJDBC02Application.class, args);
        // 실제 실행은 CommandLineRunner에서..
    }

    @Bean
    public CommandLineRunner demo(@Qualifier("bookDaoImpl") BookDao bookDao){ // 지금은 BookDaoImpl이 1개라 문제될 거 없지만.. 적어봄

        return new CommandLineRunner() {
            @Override
            public void run(String... args) throws Exception {
                // insert TEST
               // bookDao.insertBook(new Book("insertTEST", "insertAuthor", LocalDate.now()));

                // select TEST
                List<Book> books = bookDao.findAllBooks();
                for (Book book : books){
                    System.out.println(book);
                }

                // update TEST
                //bookDao.updateBookAuthor(11, "updateTEST");

                // delete TEST
                bookDao.deleteBook(11);
            }
        };
    }
}
