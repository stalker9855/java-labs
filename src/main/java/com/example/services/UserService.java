package com.example.services;

import java.util.List;

import com.example.entities.User;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Stateless
public class UserService {

    @PersistenceContext
    private EntityManager em;

    @Transactional
    public List<User> findAllUsers() {
        TypedQuery<User> query = em.createQuery("SELECT u FROM User u", User.class);
        List<User> users = query.getResultList();

        return users;
    }

    @Transactional
    public User findUserById(Long id) {
        return em.find(User.class, id);
    }

    @Transactional
    public void deleteUser(Long id) {
        User user = em.find(User.class, id);
        if (user != null) {
            em.remove(user);
        }
    }
}
