package com.example.services;

import java.util.List;

import com.example.entities.Author;
import com.example.entities.Book;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Stateless
public class BookService {

    @PersistenceContext
    private EntityManager em;

    public List<Book> findAllBooks() {
        TypedQuery<Book> query = em.createNamedQuery("Book.findAllBooks", Book.class);
        query.setMaxResults(10);
        List<Book> books = query.getResultList();

        return books;
    }

    public Author findAuthorById(Long authorId) {
        return em.find(Author.class, authorId);
    }

    public Book findBookById(Long id) {
        return em.find(Book.class, id);
    }

    @Transactional
    public void createBook(Book book) {
        em.merge(book);
    }

    @Transactional
    public Book updateBook(Book book) {
        Book updatedBook = em.merge(book);
        return updatedBook;
    }

    @Transactional
    public void deleteBook(Long id) {
        Book book = em.find(Book.class, id);
        if (book != null) {
            em.remove(book);
        }
    }
}
