package com.deloitte.mvc.service;

import com.deloitte.mvc.model.Todo;

import java.util.List;


public interface TodoService {

    List<Todo> getAlltodos(int todoId);
    void add(Todo todo);
    void deleteTodoById(int todoId);
    void updateTodo(Todo todo);
    Todo getTodoById(int todoId);
}
