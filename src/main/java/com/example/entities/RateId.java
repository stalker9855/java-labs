package com.example.entities;

import java.io.Serializable;
import java.util.Objects;

public class RateId implements Serializable {

    private Long user_id;
    private Long book_id;

    public RateId() {}

    public RateId(Long user_id, Long book_id) {
        this.user_id = user_id;
        this.book_id = book_id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RateId rateId = (RateId) o;
        return Objects.equals(user_id, rateId.user_id) &&
               Objects.equals(book_id, rateId.book_id);
    }

}
