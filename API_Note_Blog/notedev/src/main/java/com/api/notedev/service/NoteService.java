package com.api.notedev.service;

import com.api.notedev.model.Note;
import com.api.notedev.repository.NoteRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoteService {

    private final NoteRepository noteRepository;

    public NoteService(NoteRepository noteRepository) {
        this.noteRepository = noteRepository;
    }

    public Note saveNote(Note note) {
        return noteRepository.save(note);
    }

    public List<Note> findAllNotes() {
        return noteRepository.findAll();
    }
}
