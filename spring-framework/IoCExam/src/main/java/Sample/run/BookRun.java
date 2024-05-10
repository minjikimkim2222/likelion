package Sample.run;

import Sample.bean.Book;
import Sample.config.BookConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class BookRun {
    public static void main(String[] args) {
        System.out.println("applicationcontext 생성 전..");
        ApplicationContext context = new AnnotationConfigApplicationContext(BookConfig.class);
        System.out.println("applicationcontext 생성 후..");

        Book book = context.getBean("b", Book.class);
        book.setTitle("모두의 자바");
        book.setPrice(20000);

        System.out.println(book);
    }
}
