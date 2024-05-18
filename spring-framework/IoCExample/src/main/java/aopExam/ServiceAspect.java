package aopExam;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ServiceAspect {
    // @Before - Spring AOP가 제공하는 advice 중 하나, 조인 포인트(여기선 메서드) 전에 실행..
    // pointCut - execution 표현식으로 어떤 클래스의 메서드를 결합할 건지 알려줌..
    // @Aspect - advice + pointCut을 합친 것..
        // 이 파일을 참고해, target코드 어디어디에 advice 코드를 끼워놓을건지 알려줌
//    @Before("execution(* aopExam.SimpleService.*(..))")
//    public void beforeServiceMethod(JoinPoint joinPoint){
//        System.out.println("Before ::::::: " + joinPoint.getSignature().getName()); // 메서드 이름 리턴..
//    }

    // PointCut에 id 지정
    @Pointcut("execution(* aopExam.SimpleService.*(..))")
    public void pc(){}; // id는 pc

    @Pointcut("execution(* aopExam.SimpleService.hungry())")
    public void pc2(){};

    @Before("pc()")
    public void beforeServiceMethod(JoinPoint joinPoint){
        System.out.println("Before ::::::: " + joinPoint.getSignature().getName());
    }

    // afterReturning advice 어노테이션 추가..
//    @AfterReturning("pc()")
//    public void afterServiceMethod(JoinPoint joinPoint){
//        System.out.println("After ::::::: " + joinPoint.getSignature().getName());
//    }

    // afterReturning에 returning 속성 추가..
    // 애너테이션의 returning 속성에서 지정한 이름(result)과 메서드의 매개변수 이름(result)이 일치
    @AfterReturning(pointcut = "pc()", returning = "result")
    public void afterServiceMethod(JoinPoint joinPoint, Object result){
        System.out.print("After ::::::: " + joinPoint.getSignature().getName());
        System.out.println(" , return value : " + result);
    }

    @Before("execution(* setFood(..))")
    public void beforeSetFoodMethod(JoinPoint joinPoint){
        System.out.println("Before, args ::::::: " + joinPoint.getSignature().getName());

        // 실제 args 가져오기
        Object[] args = joinPoint.getArgs();
        for (Object obj : args){
            System.out.println("::::::: 인자 ---> " + obj);
        }
    }

    // After 어노테이션 추가
    @After("pc()")
    public void afterServiceMethod(JoinPoint joinPoint){
        System.out.println("After ::::::: " + joinPoint.getSignature().getName());
    }

    // @AfterThrowing 어노테이션 추가..
        // SimpleService에 어떠한 예외도 없다면.. 이 advice 코드는 실행되지 않는다..
        // 예외가 발생하는 메서드를 추가해본다.. SimpleService에 simpleError 메서드..
    @AfterThrowing("pc()")
    public void afterThrowingServiceMethod(JoinPoint joinPoint){
        System.out.println("AfterThrowing ::::::: " + joinPoint.getSignature().getName());
    }

    // '잘못된' @Around 어노테이션 추가..
    // @Around 어드바이스를 제대로 사용하기 위해서는 ProceedingJoinPoint 객체를 사용해, target 메서드를 호출해야 한다!
//    @Around("pc()")
//    public void aroundServiceMethod(JoinPoint joinPoint){
//        System.out.println("Around ::::::: " + joinPoint.getSignature().getName());
//    }

    // '올바른' @Around 어노테이션 추가..
    @Around("pc()")
    public String around(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("Around run ::::::: 실제 호출된 메서드가 실행 전 할일 구현...");

        String value = (String) pjp.proceed(); // 실제 target 메서드 호출.. 실제 실행된 값 반환
        value += "minjiki2 around app run !!!";

        // pjp.proceed() 전후를 기준으로..
        System.out.println("Around run ::::::: 실제 호출된 메서드가 실행 후 할일 구현...");
        return value;
    }

}
