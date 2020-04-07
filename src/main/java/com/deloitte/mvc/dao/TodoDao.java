package com.deloitte.mvc.dao;

import com.deloitte.mvc.model.Todo;

import java.util.List;


public interface TodoDao {

    List<Todo> getAlltodos(int todoId);

    void persist(Todo todo);

    void deleteTodoById(int todoId);

    void updateTodo(Todo todo);

    Todo getTodoById(int todoId);
}
