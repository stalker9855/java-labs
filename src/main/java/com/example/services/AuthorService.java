package com.example.services;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    public Map<Long, Integer> sumBooksByAuthor() {
    List<Object[]> results = em.createQuery(
        "SELECT a.id, COUNT(b) FROM Author a LEFT JOIN a.books b GROUP BY a.id", Object[].class).getResultList();

    Map<Long, Integer> booksCountByAuthor = new HashMap<>();

    for (Object[] result : results) {
      Long authorId = (Long) result[0];
      Integer booksCount = ((Long) result[1]).intValue();
      booksCountByAuthor.put(authorId, booksCount);
    }
    return booksCountByAuthor;

  }
}
