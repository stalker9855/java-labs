package com.example.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "\"books\"")
@NamedQueries({
        @NamedQuery(name = "Book.findAllBooks", query = "SELECT b FROM Book b ORDER BY b.id ASC")
})
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @NotBlank
    @NotNull(message = "Title is required")
    private String title;

    @NotNull(message = "Description is required")
    @NotBlank
    private String description;

    @NotNull(message = "Author is required")
    @OneToOne
    @JoinColumn(name = "author_id", referencedColumnName = "id")
    private Author author;

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
