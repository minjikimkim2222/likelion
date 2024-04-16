package org.day24.실습코드.도서_관리_시스템;

import java.util.*;

public class Book implements Comparable<Book>{
    private String bookName;
    private String author;
    private int year;

    public Book(String bookName, String author, int year) {
        this.bookName = bookName;
        this.author = author;
        this.year = year;
    }

    // getters

    public String getBookName() {
        return bookName;
    }

    public String getAuthor() {
        return author;
    }

    public int getYear() {
        return year;
    }

    // 책 제목이 같으면 객체 같게끔 취급한다!

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Book book)) return false;
        return Objects.equals(getBookName(), book.getBookName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getBookName());
    }

    // implements Comparable - compareTo

    @Override
    public int compareTo(Book o) {
        return this.year - o.getYear();
    }
}

class BookManager{
    private List<Book> arrList = new ArrayList<>();
    public void addBook(Book book) {
        if (arrList.contains(book)){ // 이미 book을 가지고 있으면 추가 안 하고 그냥 리턴
            return ;
        }
        arrList.add(book);
    }
    public void displayBooks() {
        Iterator<Book> bookIterator = arrList.iterator();

        while (bookIterator.hasNext()){
            Book book = bookIterator.next();
            System.out.print("책 제목 : " + book.getBookName());
            System.out.print(", 저자 : " + book.getAuthor());
            System.out.print(", 출간연도 : " + book.getYear());
            System.out.println();
        }
    }

    // 출판연도 순으로 정렬
    public void sortBooksByYear() {
        // Collections.sort(list)를 쓰기 위해, HashSet<Book> -> ArrayList<Book>으로 변경해야 함!!
        Collections.sort(arrList);
    }
}
class BookTest {
    public static void main(String[] args) {
        BookManager manager = new BookManager();
        manager.addBook(new Book("모두의 자바", "강경미", 2015));
        manager.addBook(new Book("이거이 자바다", "신용권", 2018));
        manager.addBook(new Book("자바의 정석", "남궁성", 2013));
        manager.addBook(new Book("모두의 자바", "강경미2", 2014)); // 책 제목 중복 시도!

        manager.displayBooks();
        manager.sortBooksByYear();
        System.out.println("******출판연도 순으로 정렬했습니다.*******");
        manager.displayBooks();
    }
}
