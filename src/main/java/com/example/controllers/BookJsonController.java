package com.example.controllers;

import com.example.services.BookService;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("json")
@RequestScoped
public class BookJsonController {

  @Inject
  private BookService bookService;

  @GET
  @Path("/books")
    public Response getBooksJson() {
        try {
            String booksJson = bookService.getBooksJson(); 
            System.out.println(booksJson);
            return Response.ok(booksJson, MediaType.APPLICATION_JSON).build(); 
        } catch (Exception e) {
            e.printStackTrace();
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                           .entity("Error fetching books data")
                           .build(); 
        }
    }
}
