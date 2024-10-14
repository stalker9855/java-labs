package com.example.containers;

import jakarta.enterprise.context.ApplicationScoped;
import java.util.ArrayList;
import java.util.List;

import com.example.models.Note;

@ApplicationScoped
public class NoteContainer {
    private List<Note> notes = new ArrayList<>(List.of(
            new Note("Task", "1"),
            new Note("Task", "2"),
            new Note("Task", "3")));

    public void addNotes(Note item) {
        notes.add(item);
    }

    public List<Note> getNotes() {
        return notes;
    }

    public void clearNotes() {
        notes.clear();
    }

    public void deleteById(int id) {
        notes.removeIf(note -> note.getId() == id);
    }
}
