package org.example.restexam.service;

import org.assertj.core.api.Assertions;
import org.example.restexam.domain.Todo;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class TodoServiceTest {

    @Autowired
    private TodoService todoService;

    private static final Logger log = LoggerFactory.getLogger(TodoServiceTest.class);
    @Test
    void getTodos() {
        todoService.addTodo("todo1");
        todoService.addTodo("todo2");

        List<Todo> todos = todoService.getTodos();
        log.info("todos : {}" , todos);

    }

    @Test
    void getTodoById() {

    }

    @Test
    void addTodo() {
        Todo addTodo = todoService.addTodo("todo1");

        log.info("addTodo - id: " + addTodo.getId());
        log.info("addTodo - todo : " + addTodo.getTodo());
        log.info("addTodo - done : " + addTodo.isDone());

    }

    @Test
    void updateTodoDone() {
        Todo updatedTodo = todoService.addTodo("update test");
        Long id = updatedTodo.getId();

        Todo originTodo = todoService.getTodoById(id);
        log.info("originTodo : {}", originTodo);

        Todo updatedtoggleTodo = todoService.updateTodoDone(id);
        log.info("upddatedtoggleTodo : {}", updatedtoggleTodo);
    }

    @Test
    void updateTodo() {
        // 새로운 Todo를 추가합니다.
        Todo addedTodo = todoService.addTodo("original Todo");
        Long id = addedTodo.getId();

        log.info("Before update - addedTodo: {}", addedTodo);

        // 업데이트할 정보를 가진 새로운 Todo 객체를 생성합니다.
        Todo updatedTodoInfo = new Todo();
        updatedTodoInfo.setId(id);
        updatedTodoInfo.setTodo("updated Todo");
        updatedTodoInfo.setDone(true);

        // Todo를 업데이트합니다.
        Todo updatedTodo = todoService.updateTodo(updatedTodoInfo);
        log.info("After update - updatedTodo: {}", updatedTodo);

        // 데이터베이스에서 업데이트된 Todo를 다시 조회합니다.
        Todo foundUpdatedTodo = todoService.getTodoById(id);

        assertNotNull(foundUpdatedTodo);
        assertEquals("updated Todo", foundUpdatedTodo.getTodo());
        assertTrue(foundUpdatedTodo.isDone());

    }

    @Test
    void deleteTodo() {

    }
}