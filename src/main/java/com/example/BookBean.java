package com.example;

import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;

import java.util.ArrayList;
import java.util.List;
import java.io.Serializable;

@Named
@SessionScoped
public class BookBean implements Serializable {
    private List<Book> books = new ArrayList<>();
    private String newTitle;
    private String newAuthor;
    // private LocalDate newReleaseDate;

    public BookBean() {
        books.add(new Book("1984", "George Orwell"));
        books.add(new Book("Lord of The Rings", "J. R. R. Tolkien"));
        books.add(new Book("La Divina Commedia", "Dante Alighieri"));
    }

    public List<Book> getBooks() {
        return books;
    }

    public String getNewTitle() {
        return newTitle;
    }

    public String getNewAuthor() {
        return newAuthor;
    }

    // public LocalDate getNewReleaseDate() {
    // return newReleaseDate;
    // }

    // public void setNewReleaseDate(LocalDate newReleaseDate) {
    // this.newReleaseDate = newReleaseDate;
    // }

    public void setNewAuthor(String newAuthor) {
        this.newAuthor = newAuthor;
    }

    public void setNewTitle(String newTitle) {
        this.newTitle = newTitle;
    }

    public String addBook() {
        if (newTitle != null && !newTitle.trim().isEmpty() && newAuthor != null && !newAuthor.trim().isEmpty()) {
            Book newBook = new Book(newTitle, newAuthor);
            books.add(newBook);
            newTitle = "";
            newAuthor = "";
            return "success";
        } else {
            return "failure";
        }
    }
}
