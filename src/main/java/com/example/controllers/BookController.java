package com.example.controllers;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.mvc.Controller;
import jakarta.mvc.Models;
import jakarta.mvc.View;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;

import java.util.List;

import com.example.entities.Book;
import com.example.services.BookService;

@Path("books")
@Controller
@RequestScoped
public class BookController {

    @Inject
    private BookService bookService;

    @Inject
    private Models models;

    @GET
    @View("books.xhtml")
    public void getBooks() {
        List<Book> books = bookService.findAllBooks();
        models.put("books", books);
    }

}
