package org.day22;

import java.beans.EventHandler;

public class EventProcessor {
    public void processEvent(String event) {
        // 로컬 내부 클래스 정의
        class EventHandler {
            public void handle() {
                System.out.println("처리 중인 이벤트: " + event);
                // 이벤트 처리 로직
            }
        }

        //  >>>>>>>>>> 로컬 내부 클래스의 인스턴스 생성 및 사용 <<<<<<<<<<
        EventHandler handler = new EventHandler();
        handler.handle();
    }
}
class EventHandlerTest {
    public static void main(String[] args) {
        EventProcessor event = new EventProcessor();
        event.processEvent("button click");

    }
}
