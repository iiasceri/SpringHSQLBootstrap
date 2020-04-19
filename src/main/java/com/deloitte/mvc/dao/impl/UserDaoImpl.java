package com.deloitte.mvc.dao.impl;

import com.deloitte.mvc.dao.UserDao;
import com.deloitte.mvc.model.User;
import lombok.RequiredArgsConstructor;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Repository
public class UserDaoImpl implements UserDao {

    private final SessionFactory sessionFactory;

    @Override
    public List<User> getAllUsers() {
        return sessionFactory.getCurrentSession()
                .createQuery("SELECT u FROM User u", User.class)
                .getResultList();
    }

    @Override
    public Optional<User> getUserById(int id) {
        return sessionFactory.getCurrentSession()
                .createQuery("SELECT u FROM User u " +
                        "WHERE id=:uId", User.class)
                .setParameter("uId", id)
                .getResultList().stream().findFirst();
    }

    @Override
    public void persist(User user) {
        sessionFactory.getCurrentSession().persist(user); //TODO check if it works properly
    }

    @Override
    public void deleteUserById(int userId) {
        sessionFactory.getCurrentSession()
                .createQuery("DELETE FROM User u " +
                        "WHERE u.id=:userId")
                .setParameter("userId", userId)
                .executeUpdate();
    }
}
