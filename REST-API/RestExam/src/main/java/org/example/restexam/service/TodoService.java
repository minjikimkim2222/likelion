package org.example.restexam.service;

import lombok.RequiredArgsConstructor;
import org.example.restexam.domain.Todo;
import org.example.restexam.repository.TodoRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TodoService {
    private final TodoRepository todoRepository;

    @Transactional(readOnly = true)
    public List<Todo> getTodos(){
        return todoRepository.findAll(Sort.by("id").descending());
    }

    @Transactional(readOnly = true)
    public Todo getTodoById(Long id){
        Todo todo = todoRepository.findById(id).orElse(null);
        return todo;
    }

    @Transactional
    public Todo addTodo(String todo){
        Todo newTodo = new Todo(todo);
        newTodo.setDone(false); // 디폴트 done값을 false라고 설정함..

        Todo savedTodo = todoRepository.save(newTodo);
        return savedTodo;
    }

    @Transactional
    public Todo updateTodoDone(Long id){ // id값에 해당하는 투두 done을 토글하도록!!
        Todo updateTodo = null;

        try {
            updateTodo = todoRepository.findById(id).orElseThrow(); // 찾는 투두가 없다면 예외발생..
            updateTodo.setDone(!updateTodo.isDone());
        } catch (Exception e){
            System.out.println(e.getMessage());
        }

        return updateTodo;
    }

    @Transactional
    public Todo updateTodo(Todo todo){ // id에 해당하는 투두 정보를 바꾸고 싶어요
        Todo updatedTodo = getTodoById(todo.getId());

        if (updatedTodo != null) {
            updatedTodo.setTodo(todo.getTodo());
            updatedTodo.setDone(todo.isDone());
        }

        return todoRepository.save(updatedTodo);
    }

    public void deleteTodo(Long id){ // id에 해당하는 투두 삭제
        todoRepository.deleteById(id);
    }
}
