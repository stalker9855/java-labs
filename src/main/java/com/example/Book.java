package com.example;

public class Book {
    private String title;
    private String author;
    // private LocalDate releaseDate;

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
        // this.releaseDate = releaseDate;
    }

    public String getTitle() {
        return this.title;
    }

    public String getAuthor() {
        return this.author;
    }

    // public LocalDate getReleaseDate() {
    // return this.releaseDate;
    // }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    // public void setReleaseDate(LocalDate releaseDate) {
    // this.releaseDate = releaseDate;
    // }
}
