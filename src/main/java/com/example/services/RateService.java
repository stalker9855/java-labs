package com.example.services;

import java.util.Optional;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Stateless
public class RateService {
  @PersistenceContext
  private EntityManager em;

  public Optional<Double> avgRatingBook(Long bookId) {
    Double avgRating = em.createQuery("SELECT AVG(r.rate) FROM Rate r where r.book_id = :bookId", Double.class)
        .setParameter("bookId", bookId).getSingleResult();

    return Optional.ofNullable(avgRating);
  }
}
