package com.example.DTO;

import com.example.entities.Book;

public class BookDTO {
    private Long id;
    private String title;
    private String description;
    private String authorName;

    public BookDTO(Book book) {
        this.id = book.getId();
        this.title = book.getTitle();
        this.description = book.getDescription();
        this.authorName = book.getAuthor().getName();
    }

	public Long getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}


	public String getDescription() {
		return description;
	}


	public String getAuthorName() {
		return authorName;
	}


}
