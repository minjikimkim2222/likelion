package aopExam;

import org.springframework.stereotype.Service;

@Service
public class SimpleService {

    public String doSomething(){
        // 핵심관심. target
        System.out.println("SimpleService doSomething run");
        return "Doing something...";
    }

    // 메서드 한 개 더 추가..
    public void hungry(){
        System.out.println("점심에 뭐 먹을까..?");

        // @AfterThrowing 테스트를 위해 예외 추가..
//        if (1 == 1)
//            throw new RuntimeException(); // 예외 무조건 발생 !
    }

    // 메서드 한 개 더더 추가
    public void setFood(String food){
        System.out.println("setFood method run...");
    }
}
