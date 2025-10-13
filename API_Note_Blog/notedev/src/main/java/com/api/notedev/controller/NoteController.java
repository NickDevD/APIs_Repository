package com.api.notedev.controller;

import com.api.notedev.model.Note;
import com.api.notedev.service.NoteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class NoteController {

    private final NoteService noteService;

    public NoteController(NoteService noteService) {
        this.noteService = noteService;
    }

    @PostMapping("/create")
    public ResponseEntity<Note> createNote(@RequestBody Note note) {
        Note newNote = noteService.saveNote(note);
        return ResponseEntity.status(HttpStatus.CREATED).body(newNote);
    }

    @GetMapping("/get")
    public ResponseEntity<List<Note>> getNote(){
        noteService.findAllNotes();
        return ResponseEntity.status(HttpStatus.OK).body(noteService.findAllNotes());
    }
}
