package aopExam;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ServiceAspect {
    // ..과 . 차이?
    // Before은 advice유형.. "execution()" 이 부분은 pointCut
    // 이 advice랑 pointCut 2개를 합친 aspect

    // 포인트컷에 id 지정
    @Pointcut("execution(* aopExam.SimpleService.*(..))")
    public void pc(){};

    @Pointcut("execution(* hungry(..))")
    public void pc2(){};
    @Before("pc()") // *.* -> 모든 클래스.모든 메서드 - pointcut 지정
    public void before(JoinPoint joinPoint){
        System.out.println("Before ::::::: " + joinPoint.getSignature().getName()); // 메서드 이름 리턴..
    }

    @After("pc()")
    public void after(){
        System.out.println("After ::::::: ");
    }

    // 애너테이션의 returning 속성에서 지정한 이름(result)과 메서드의 매개변수 이름(result)이 일치해야 한다
    //@AfterReturning(pointcut = "execution(String aopExam.SimpleService.*(..))", returning = "result")
    @AfterReturning(pointcut = "execution(* aopExam.SimpleService.*(..))", returning = "result")
    public void afterReturningServiceMethod(JoinPoint joinPoint, Object result){
        System.out.println("After method: " + joinPoint.getSignature().getName() +  ", return value " + result);
    }

    // Spring AOP의 포인트컷 표현식에서 메서드 이름 앞에 패키지를 지정하지 않으면, 해당 메서드 이름을 가진 모든 패키지의 메서드가 포인트컷에 매칭
    @Before("execution(* setFood(..))") // *는 반환타입 지정, setName이름을 가진 모든 메서드, (..) 메서드 매개변수 수,타입 상관 없음
    public void beforeName(JoinPoint joinPoint){
        System.out.println("beforeName :::::::::::::  ");
        System.out.println(joinPoint.getSignature().getName());; // 실제 실행되는 메서드 이름 출력..

        Object[] args = joinPoint.getArgs(); // 해당 메서드의 argument를 Object 배열로 리턴..
        for (Object object : args){
            System.out.println(":::::::인자 ---> " + object);
        }
    }

    @AfterThrowing(value = "pc2()", throwing = "ex") // hugry 메서드에 예외발생 추가..
    public void afterThrowing(Throwable ex){ // 예외발생시킨 후에..
        System.out.println("AfterThrowing ##########");
        System.out.println("exception value : " + ex);
    }

    @Around("pc()")
    public String around(ProceedingJoinPoint pjp) throws Throwable{ // joinPoint와 달리, 중간에 가로챘다가 다시 돌려줌..
        System.out.println("Arround run :::::::::::::::::::: 실제 호출된 메서드가 실행되기 전에 할 일 구현..");

        String value = (String) pjp.proceed(); // 실제 target 메서드를 호출 .., 실제 실행된 값 반환..
        value += "minjiki2 app run !!";
        // pjp.proceed() 전후를 기준으로..
        System.out.println("Arround run :::::::::::::::::::: 실제 호출된 메서드가 실행된 후 할 일 구현..");
        return value;
    }
}
