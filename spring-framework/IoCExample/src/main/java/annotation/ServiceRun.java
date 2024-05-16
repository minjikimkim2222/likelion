package annotation;

import java.lang.reflect.Method;

public class ServiceRun {
    public static void main(String[] args) throws Exception {
        // 다시 말하지만 이런 코드는 개발자가 아닌, 스프링이 만들건데..
        // 어떤 원리인지 알려고 적는 것..
        Method[] declaredMethod =
                Service.class.getDeclaredMethods();

        Service service = new Service();

        for (Method method : declaredMethod){
            if (method.isAnnotationPresent(PrintAnnotation.class)){
                System.out.println("[[[[[[[ " + method.getName() + " ]]]]]]");

                PrintAnnotation printAnnotation = method.getAnnotation(PrintAnnotation.class);

                for (int i = 0; i< printAnnotation.number(); i++){
                    // 어노테이션의 number만큼, value값을 출력 !!
                    System.out.print(printAnnotation.value());
                }
                System.out.println();
            }
            method.invoke(service); // 원래 method에서 실행시켜주는 부분...
        }
    }
}
