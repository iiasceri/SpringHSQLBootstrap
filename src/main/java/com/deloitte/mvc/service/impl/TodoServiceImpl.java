package com.deloitte.mvc.service.impl;

import com.deloitte.mvc.dao.TodoDao;
import com.deloitte.mvc.model.Todo;
import com.deloitte.mvc.service.TodoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;



@RequiredArgsConstructor
@Service
@Transactional
public class TodoServiceImpl implements TodoService {

    private final TodoDao todoDao;

    @Override
    public List<Todo> getAlltodos(int id) {
        return todoDao.getAlltodos(id) ;
    }

    @Override
    public void add(Todo todo) {
        todoDao.persist(todo);
    }

    @Override
    public void deleteTodoById(int todoId) {
        todoDao.deleteTodoById(todoId);
    }

    @Override
    public void updateTodo(Todo todo){
        todoDao.updateTodo(todo);
    }

    @Override
    public Todo getTodoById(int todoId) {
        return todoDao.getTodoById(todoId);
    }
}
