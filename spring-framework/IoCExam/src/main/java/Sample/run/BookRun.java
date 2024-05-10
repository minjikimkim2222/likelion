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

        // 싱글톤 테스트
        Book bookBean1 = context.getBean("bookBean1", Book.class);
        bookBean1.setTitle("book1");
        bookBean1.setPrice(1000);

        System.out.println(bookBean1);
        Book bookBean2 = context.getBean("bookBean2", Book.class);
        bookBean2.setTitle("book2");
        bookBean2.setPrice(2000);
        System.out.println(bookBean2);
            // 싱글톤 패턴은 applicationcontext에서 @Configuration 클래스 안에 정의된 @Bean 어노테이션을 보고, 빈을 등록해,
            // 이때서야 '인스턴스화'를 한다!!

    }
}
