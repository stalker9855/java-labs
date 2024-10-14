package com.example.models;

import java.time.LocalDate;

public class Note {

    private static int idCounter = 1;
    private int id;
    private String title;
    private String description;
    private LocalDate createdAt;

    public Note(String title, String description) {
        this.id = idCounter++;
        this.title = title;
        this.description = description;
        this.createdAt = LocalDate.now();
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDate createdAt) {
        this.createdAt = createdAt;
    }
}
