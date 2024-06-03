package org.example.restexam.controller;

import lombok.RequiredArgsConstructor;
import org.example.restexam.domain.Todo;
import org.example.restexam.service.TodoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/todos")
@RequiredArgsConstructor
public class TodoController {

    private final TodoService todoService;
    @GetMapping // /api/todos -- GET (Read) -- todoList를 리턴
    public List<Todo> getTodos(){
        return todoService.getTodos();
    }

    @GetMapping("/{id}")
    public Todo getTodoById(@PathVariable Long id){
        return todoService.getTodoById(id);
    }

    // Spring에서 HTTP 요청의 본문(body)를 자바 객체에 매핑할 때.. - @RequestBody
    @PostMapping
    public Todo addTodo(@RequestBody Todo todo){
        return todoService.addTodo(todo.getTodo());
    }

    // put vs patch
    // -- 내용 전체를(엔디티 자체를) 수정할 때는 put
    // -- 부분만 바뀔 때는 patch
    @PatchMapping("/{id}")
    public Todo updatetodoDone(@PathVariable Long id){
        return todoService.updateTodoDone(id);
    }

    @PutMapping
    public Todo updateTodo(@RequestBody Todo todo){
        return todoService.updateTodo(todo);
    }

    @DeleteMapping("/{id}")
    public String deleteTodo(@PathVariable Long id){
        todoService.deleteTodo(id);
        return "ok";
    }
}
