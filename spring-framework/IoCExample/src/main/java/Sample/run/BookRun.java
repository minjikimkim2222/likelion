package Sample.run;

import Sample.bean.Book;
import Sample.config.BookConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class BookRun {
    public static void main(String[] args) {

        // 스프링 IoC 컨테이너를 이용해서 객체를 생성하는 경우..
        // 스프링 컨테이너에게 어떤 객체를 빈으로 등록할지 알려야 해요..
            // 1. 자바 파일을 통해서 알려줌..

        // BeanFactory -- 빈을 생성하는데 간단한 기능만 제공..
        // 따라서 BeanFactory를 상속하고 기타 기능 제공해주는 ApplicationContext 사용..
        System.out.println("applicationContext 생성 전...");
        ApplicationContext context = new AnnotationConfigApplicationContext(BookConfig.class);
            // 자바 설정 파일(BookConfig.class가 누군지 알려주기)

        System.out.println("applicationContext 생성 후...");

        // Book 빈 가져오기
        Book bean1 = context.getBean(Book.class);
        bean1.setTitle("book1");
        bean1.setPrice(1000);
        System.out.println(bean1);

        Book bean2 = (Book)context.getBean("book"); // getBean이 타입이 아닌 book id로 가져와서 형변환 해줘야 함..
        bean2.setTitle("book2");
        bean2.setPrice(2000);
        System.out.println(bean2);
        System.out.println(bean1); // book1이 아닌 book2 출력..

        // 두 개의 Book 빈이 동일한 인스턴스인지 확인
        if (bean1 == bean2)
            System.out.println("bean1과 bean2는 동일한 인스턴스입니다.");
        else
            System.out.println("bean1과 bean2는 서로 다른 인스턴스입니다.");
    }
}
