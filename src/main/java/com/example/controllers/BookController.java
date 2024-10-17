package com.example.controllers;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.mvc.Controller;
import jakarta.mvc.Models;
import jakarta.mvc.View;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.FormParam;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.core.Response;

import java.util.List;

import com.example.entities.Author;
import com.example.entities.Book;
import com.example.services.AuthorService;
import com.example.services.BookService;

@Path("books")
@Controller
@RequestScoped
public class BookController {

    @Inject
    private BookService bookService;

    @Inject
    private AuthorService authorService;

    @Inject
    private Models models;

    @GET
    @View("books.xhtml")
    public void showAllBooks() {
        List<Book> books = bookService.findAllBooks();
        List<Author> authors = authorService.findAllAuthors();
        models.put("authors", authors);
        models.put("books", books);
    }

    @GET
    @Path("/{id}/bookEdit")
    @View("bookEdit.xhtml")
    public Response showEditBook(@PathParam("id") Long id) {
        Book book = bookService.findBookById(id);
        if (book == null) {
            return Response.ok("redirect:books").build();
        }
        models.put("book", book);

        return Response.ok("bookEdit.xhtml").build();
    }

    @POST
    @Consumes("application/x-www-form-urlencoded")
    public Response createBook(@FormParam("title") String title, @FormParam("description") String description,
            @FormParam("author") Long authorId) {
        Book book = new Book();
        Author author = bookService.findAuthorById(authorId);

        book.setTitle(title);
        book.setDescription(description);
        book.setAuthor(author);
        bookService.createBook(book);
        return Response.ok("redirect:books")
                .build();
    }

    @PUT
    @Path("{id}/bookEdit")
    @Consumes("application/x-www-form-urlencoded")
    public Response updateBook(@PathParam("id") Long id, @FormParam("title") String title,
            @FormParam("description") String description, @FormParam("author") Long authorId) {
        System.out.println("Book ID: " + id);
        System.out.println("Book Title: " + title);
        System.out.println("Book Description: " + description);
        System.out.println("Author ID: " + authorId);
        Book existingBook = bookService.findBookById(id);
        if (existingBook == null) {
            return Response.status(Response.Status.NOT_FOUND).entity("Book not found").build();
        }
        Author author = bookService.findAuthorById(authorId);
        existingBook.setTitle(title);
        existingBook.setDescription(description);
        existingBook.setAuthor(author);
        bookService.updateBook(existingBook);
        return Response.ok("redirect:books").build();
    }

    @DELETE
    @Path("{id}")
    public Response deleteBook(@PathParam("id") Long id) {
        Book book = bookService.findBookById(id);
        if (book == null) {
            return Response.status(Response.Status.NOT_FOUND).entity("Book not found").build();
        }

        System.out.println("AUTHOR ID" + book.getAuthor().getId());
        System.out.println(book.getId());
        bookService.deleteBook(id);
        return Response.ok("redirect:books").build();
    }

}
