package com.example.services;

import java.util.List;

import com.example.entities.Author;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;

@Stateless
public class AuthorService {

    @PersistenceContext
    private EntityManager em;

    public List<Author> findAllAuthors() {
        TypedQuery<Author> query = em.createNamedQuery("Author.findAllAuthors", Author.class);
        List<Author> books = query.getResultList();

        return books;
    }
}
