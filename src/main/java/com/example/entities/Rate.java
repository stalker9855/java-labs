package com.example.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "\"rate_books_users\"")
@IdClass(RateId.class)
public class Rate {

    @Id
    @NotNull
    private Long user_id;

    @Id
    @NotNull
    private Long book_id;

    private short rate;

    public Long getUserId() {
        return this.user_id;
    }

    public void setUserId(Long user_id) {
        this.user_id = user_id;
    }

    public Long getBookId() {
        return this.book_id;
    }

    public void setBookId(Long book_id) {
        this.book_id = book_id;
    }

    public short getRate() {
        return this.rate;
    }

    public void setRate(short rate) {
        this.rate = rate;
    }
}
