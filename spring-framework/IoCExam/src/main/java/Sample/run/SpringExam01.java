package Sample.run;

import Sample.bean.MyBean;
import Sample.config.MyBeanConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SpringExam01 {
    public static void main(String[] args) {
        // 1. java에서 인스턴스 직접 생성
//        MyBean bean = new MyBean();
//        bean.setName("minjiki2");
//
//        System.out.println(bean);

        // 2. 스프링 ioc container에게 MyBean 인스턴스를 생성하게끔..
        // 스프링 컨테이너에게 나 이걸 빈으로 할거야, 라고 알려줘야 하지 않을까요??
            // 1. 어노테이션으로 알려줌 .. -- 컴포넌트 스캔되도록!
            // 2. 자바파일(설정파일)을 통해서 알려줌 -- MyBeanConfig.java 참고..

            // BeanFactory -- 빈을 생성하는데 간단한 기능만 포함..
            // ApplicationContext(TVFactory .. 역할) -- BeanFactory를 상속받아, 다양한 기능 제공..
        System.out.println("applicationContext 생성 전!!");
        ApplicationContext context = new AnnotationConfigApplicationContext(MyBeanConfig.class); // 여기서 @Bean붙은 애들 다 빈 객체로 등록..
        System.out.println("applicationContext 생성 후!!");
        MyBean bean1 = (MyBean)context.getBean("myBean"); // 등록된 bean들 중, id가 myBean인 애들을 데려옴
            // dependency lookup 방색 -- 직접, 의존성 이름을 얘기해서, 객체 생성..

        bean1.setName("minjiki2");
        System.out.println(bean1);

        // MyBean bean2 = context.getBean(MyBean.class);
        // bean id가 아니라, bean type만 알려줌.. (MyBeanConfig.java에서 myBean2 추가 전..)
        // 해당 타입의 객체가 하나만 존재하면 문제없다. 그러나 2개 이상일 때는 ..ㅜㅜ

        MyBean bean2 = context.getBean("myBean2", MyBean.class);
        bean2.setName("test");
        bean2.setCount(2);
        System.out.println(bean2);
        System.out.println(bean1); // bean1 name이 test로 바뀐 것을 알 수 있다..
            // bean은 싱글톤 패턴이기에, bean1과 bean2 인스턴스가 같다면, 1개의 인스턴스만 생성할 수 있게 해, 리소스 아끼기 ..
        if (bean2 == bean1)
            System.out.println("같아요.");

        // 이때 자바파일에 myBean2 등록.. - 타입만 알려주며 getBean을 가져올 때, 똑같은 타입이 2개 이상 존재한다면..? -> 위에서 bean2 수정..
        // bean1과 bean2의 인스턴스가 다르기에, 각각 다른 이름값 잘 적용됨..

        // prototype scope 추가 이후,, 자바 설정파일에서..
        MyBean bean4 = context.getBean("myBean3", MyBean.class);
        bean4.setName("hong");

        MyBean bean5 = context.getBean("myBean3", MyBean.class);
        bean5.setName("lee");
            // 만일 싱글톤이라면, Bean을 applicationContext 생성될 때, 미리 생성되서, bean4와 bean5가 모두 마지막으로 생성된 객체인 "lee"값을 가지겠지요..
            // 하지만 prototype으로 바꿨더니, Bean은 getBean으로 빈을 가져올 때'마다' 각각의 빈이 생성되고,각자의 이름이 잘 들어간다..
        System.out.println(bean4);
        System.out.println(bean5);

            // 3. xml을 통해서 알려줌 -- 스프링 버전 3 이전에는 이 방법밖에 안되었다.. 지금은 이 방법보다는 자바파일을 통해 알려주는 방식 선호..

    }
}
