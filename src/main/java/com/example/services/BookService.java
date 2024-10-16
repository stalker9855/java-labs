package com.example.services;

import java.util.List;

import com.example.entities.Book;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;

@Stateless
public class BookService {

    @PersistenceContext
    private EntityManager em;

    public List<Book> findAllBooks() {
        TypedQuery<Book> query = em.createNamedQuery("Book.findAllBooks", Book.class);
        query.setMaxResults(10);
        List<Book> books = query.getResultList();

        em.close();

        return books;
    }
}
