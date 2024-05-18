package aopExam;

import org.springframework.stereotype.Service;

@Service
public class SimpleService {

    public String doSomething(){
        // 핵심관심. target
        System.out.println("SimpleService doSomething() run...");
        return "Doing something...";
    }

    // 메서드 한 개 더 추가..
    public void hungry(){
        // 비즈니스로직. target
        System.out.println("SimpleService hungry() run...");
    }

    // @Before - args 가져오는 거 테스트하기 위해 추가..
    public void setFood(String food, int foodId){
        System.out.println("SimpleService setFood() run...");
    }

    // @AfterThrowing 테스트를 위해, 에러를 발생시키는 메서드 추가..
    public void simpleError() throws UserMakeError{
        System.out.println("SimpleService simpleError() run...");

        if (true){ // 무조건 예외 발생시키기
            throw new UserMakeError("[사용자 정의 에러] : 일부로 에러를 발생시켰습니다..");
        }
    }

}

class UserMakeError extends RuntimeException {
    public UserMakeError(String msg){
        super(msg);
    }
}
