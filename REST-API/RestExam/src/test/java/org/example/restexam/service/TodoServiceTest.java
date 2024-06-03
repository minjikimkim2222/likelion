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
    }

    @Test
    void deleteTodo() {
    }
}