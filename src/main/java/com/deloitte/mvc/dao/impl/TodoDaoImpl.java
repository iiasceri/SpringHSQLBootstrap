package com.deloitte.mvc.dao.impl;

import com.deloitte.mvc.dao.TodoDao;
import com.deloitte.mvc.model.Todo;
import lombok.RequiredArgsConstructor;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import java.util.List;


@RequiredArgsConstructor
@Repository
public class TodoDaoImpl implements TodoDao {

    private final SessionFactory sessionFactory;

    @Override
    public List<Todo> getAlltodos(int todoId) {
        return sessionFactory.getCurrentSession()
                .createQuery("SELECT t FROM Todo t " +
                        "WHERE user_id=:uId", Todo.class)
                .setParameter("uId", todoId)
                .getResultList();
    }

    @Override
    public void persist(Todo todo) {
        sessionFactory.getCurrentSession()
                .persist(todo);
    }

    @Override
    public void deleteTodoById(int todoId) {
        sessionFactory.getCurrentSession()
                .createQuery("DELETE FROM Todo t " +
                        "WHERE t.id=:todoId")
                .setParameter("todoId", todoId)
                .executeUpdate();
    }

    @Override
    public void updateTodo(Todo todo) {
        sessionFactory.getCurrentSession()
                .createQuery("UPDATE Todo t " +
                        "SET t.todoStatus=:todoStatus " +
                        "WHERE t.id=:todoId")
                .setParameter("todoStatus", todo.getTodoStatus())
                .setParameter("todoId", todo.getId())
                .executeUpdate();

        sessionFactory.getCurrentSession()
                .createQuery("UPDATE Todo t " +
                        "SET t.lastChange=:todoLastChange " +
                        "WHERE t.id=:todoId")
                .setParameter("todoLastChange", new java.util.Date())
                .setParameter("todoId", todo.getId())
                .executeUpdate();
    }

    @Override
    public Todo getTodoById(int todoId) {
        return sessionFactory.getCurrentSession().find(Todo.class, todoId);
    }
}
