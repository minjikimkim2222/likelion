package Sample.run;

import Sample.bean.Waffle;
import Sample.config.WaffleConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class WaffleRun {
    public static void main(String[] args) {
        System.out.println("applicationContext 생성 전...");
        ApplicationContext context = new AnnotationConfigApplicationContext(WaffleConfig.class);
        System.out.println("applicationContext 생성 후...");

        // Waffle 객체 생성
        Waffle waffle = context.getBean(Waffle.class);

        // Waffle 값 설정 및 출력
        waffle.setMenu("크림와플");
        waffle.setPrice(2300);
        System.out.println(waffle);

    }
}
