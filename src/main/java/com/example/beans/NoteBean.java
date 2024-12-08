package com.example.beans;

import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.example.models.Note;

@Named
@SessionScoped
public class NoteBean implements Serializable {
    private Note note = new Note();
    private List<Note> notes = new ArrayList<>();
    private Note selectedNote; 

    public Note getNote() {
        return note;
    }

    public void setNote(Note note) {
        this.note = note;
    }

    public List<Note> getNotes() {
        return notes;
    }

    public Note getSelectedNote() {
        return selectedNote;
    }

    public void setSelectedNote(Note selectedNote) {
        this.selectedNote = selectedNote;
    }

    public void addNote() {
        if (note.getTitle() != null && !note.getTitle().isEmpty()) {
            notes.add(new Note(note.getTitle(), note.getContent()));
            note = new Note(); 
        }
    }

    public void deleteSelectedNote() {
        if (selectedNote != null) {
            notes.remove(selectedNote);
            selectedNote = null;
        }
    }
}
