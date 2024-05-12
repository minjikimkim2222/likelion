package Sample.run;

import Sample.bean.Book;
import Sample.config.BookConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class BookRun2 {
    public static void main(String[] args) {

        System.out.println("applicationContext 실행 전...");
        ApplicationContext context = new AnnotationConfigApplicationContext(BookConfig.class);
        System.out.println("applicationContext 실행 후...");

        // Book bean1 = context.getBean(Book.class);
        // 타입만 알려줌 -- 단, 해당 타입의 객체가 2개 이상일 때는, 오류 발생..

        // 그럴 때는 bean id랑 타입을 같이 알려주면 된다.
        Book bean1 = context.getBean("bookByPrototype", Book.class);
        bean1.setTitle("book1");
        bean1.setPrice(1000);
        System.out.println(bean1);

        Book bean2 = context.getBean("bookByPrototype", Book.class);
        bean2.setTitle("book2");
        bean2.setPrice(2000);
        System.out.println(bean2);
        System.out.println(bean1); // 싱글톤과 달리, book1 출력!

        if (bean1 == bean2){
            System.out.println("bean1과 bean2는 동일한 인스턴스입니다.");
        } else
            System.out.println("bean1과 bean2는 서로 다른 인스턴스입니다.");
        // 싱글톤과 달리, bean1과 bean2가 서로 다른 인스턴스라고 출력됨..
    }
}
