package com.example.controllers;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.mvc.Controller;
import jakarta.mvc.Models;
import jakarta.mvc.View;
import jakarta.websocket.server.PathParam;
import jakarta.ws.rs.FormParam;
import jakarta.ws.rs.Consumes;
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
    @View("notes.xhtml")
    public void getNotes() {
        List<Note> notes = noteContainer.getNotes();
        models.put("notes", notes);
    }

    @POST
    public Response createNote(@FormParam("newTitle") String newTitle,
            @FormParam("newDescription") String newDescription) {
        Note note = new Note(newTitle, newDescription);
        noteContainer.addNotes(note);
        System.out.println("Added");
        return Response.ok("redirect:notes").build();
    }

    @POST
    @Path("{id}/deleteNote")
    public Response deleteNote(@FormParam("id") int id) {
        noteContainer.deleteById(id);
        System.out.println("Deleted");
        return Response.ok("redirect:notes").build();
    }

}
