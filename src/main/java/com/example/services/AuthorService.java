package com.example.services;

import java.util.List;

import com.example.entities.Author;
import com.example.entities.Book;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Stateless
public class AuthorService {

    @PersistenceContext
    private EntityManager em;

    public List<Author> findAllAuthors() {
        TypedQuery<Author> query = em.createNamedQuery("Author.findAllBooks", Author.class);
        List<Author> books = query.getResultList();

        return books;
    }
}
