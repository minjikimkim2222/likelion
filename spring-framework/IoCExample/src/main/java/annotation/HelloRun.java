package annotation;

import java.lang.reflect.Method;

public class HelloRun {
    public static void main(String[] args) throws Exception{
        Hello hello = new Hello();

        // 지금 구현하는 부분은 개발자가 하는 부분이 아니고, 실제 스프링 프레임워크가 어떤 과정을 해주는지..
        Method method = hello.getClass().getDeclaredMethod("print");

        if (method.isAnnotationPresent(Count100.class)){
            // 지금 이 메서드에게 이런 어노테이션이 있니??

            // 만약에 있으면 난 너 100번 실행시키고 싶어~~
            for (int i = 0; i < 100; i++){
                hello.print();
            }
        } else {
            // 없다면 한번만..
            hello.print();
        }

    }
}
