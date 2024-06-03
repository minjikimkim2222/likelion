package org.example.restexam;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.example.restexam.domain.Todo;
import org.example.restexam.repository.TodoRepository;
import org.springframework.stereotype.Component;

//@Component
//@RequiredArgsConstructor
//public class TestDataInit {
//    private final TodoRepository todoRepository;
//
//    // 테스트용 데이터 추가
//    @PostConstruct
//    public void init(){
//        todoRepository.save(new Todo("todo1"));
//        todoRepository.save(new Todo("todo2"));
//        todoRepository.save(new Todo("todo3"));
//    }
//}
