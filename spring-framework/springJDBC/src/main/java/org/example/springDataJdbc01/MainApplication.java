package org.example.springDataJdbc01;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@SpringBootApplication
public class MainApplication {
    public static void main(String[] args) {
        SpringApplication.run(MainApplication.class, args);

        // CommandLineRunner에서 실행코드 작성..
    }

//    @Bean
//    public CommandLineRunner demo(BookRepository bookRepository){
//        return new CommandLineRunner() {
//            @Override
//            public void run(String... args) throws Exception {
//                // select TEST - 기본제공 메서드
//                Iterable<Book> books = bookRepository.findAll();
//                for (Book book : books){
//                    System.out.println(book);
//                }
//
//                // findById TEST - 기본제공 메서드
//                Book bookById = bookRepository.findById(8).get();
//                System.out.println(bookById);
//
//                // save TEST - 기본제공 메서드
//               // bookRepository.save(new Book("saveTEST", "saveAuthor", LocalDate.now()));
//
//                // deletebyId TEST - 기본제공 메서드
//              //  bookRepository.deleteById(12);
//
//                // findByName TEST - 커스텀 메서드
//                Book book = bookRepository.findByTitle("The Great Gatsby");
//                System.out.println("커스텀 메서드 테스트 !! " + book);
//
//                // findByAuthor TEST - 커스텀 메서드
//                Book book2 = bookRepository.findByAuthor("Harper Lee");
//                System.out.println("커스텀 메서드 테스트 !! 2" + book2);
//            }
//        };
//    }

    @Bean
    public CommandLineRunner batchUpdateDemo(JdbcTemplate jdbcTemplate){
        return new CommandLineRunner() {
            @Override
            public void run(String... args) throws Exception {
                List<Book> books = Arrays.asList(
                        new Book("book1", "author1", LocalDate.now()),
                        new Book("book2", "author2", LocalDate.now()),
                        new Book("book3", "author3", LocalDate.now()),
                        new Book("book4", "author4", LocalDate.now())
                );

                // prepare SQL query for batch update
                String sql = "insert into books (title,author,published_year) values (?,?,?)";

                // excute batch update
                int[] updateCounts = jdbcTemplate.batchUpdate(sql, new BatchPreparedStatementSetter() {
                    @Override
                    public void setValues(PreparedStatement ps, int i) throws SQLException {
                        Book book = books.get(i); // list로부터 book객체를 하나하나씩 받아오기..
                        ps.setString(1, book.getTitle()); // title
                        ps.setString(2, book.getAuthor()); // author

                        // LocalDate를 java.sql.Date로 변환..
                        LocalDate publishedDate = book.getPublished_year();
                        java.sql.Date sqlDate = java.sql.Date.valueOf(publishedDate);
                        ps.setDate(3, sqlDate);
                    }

                    @Override
                    public int getBatchSize() { // 배치사이즈를 books 리스트 개수만큼, 업데이트를 진행한다고 알려주어야 함..
                        return books.size();
                    }
                });

                System.out.println("Batch update completed. Number of rows affected : " + Arrays.toString(updateCounts));
            }
        };

    }
}
