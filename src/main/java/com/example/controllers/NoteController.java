package com.example.controllers;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.mvc.Controller;
import jakarta.mvc.Models;
import jakarta.mvc.UriRef;
import jakarta.mvc.View;
import jakarta.validation.Valid;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;
import jakarta.ws.rs.BeanParam;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Response;

import java.util.List;

import com.example.containers.NoteContainer;
import com.example.models.Note;

@Path("notes")
@Controller
@RequestScoped
public class NoteController {

    @Inject
    private NoteContainer noteContainer;

    @Inject
    private Models models;

    @GET
    public String getNotes() {
        List<Note> notes = noteContainer.getNotes();
        models.put("notes", notes);
        return "notes.xhtml";
    }

    @POST
    public Response createNote() {
        Note note = new Note("Hello", "Bob Ross");
        noteContainer.addNotes(note);
        System.out.println("Added");
        return Response.ok("redirect:notes").build();
    }
}
