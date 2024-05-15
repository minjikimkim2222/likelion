package org.example.jdbc02.dao;

import java.util.List;

public interface BookDao {
    void insertBook(Book book);
    List<Book> findAllBooks();

    void updateBookAuthor(int book_id, String title);
    void deleteBook(int book_id);
}
