package com.example.rohanlodhi.job2go.ui.main;

import com.example.rohanlodhi.job2go.models.Note;

import java.util.List;


public interface MainViewInterface {

    void onNotesLoaded(List<Note> notes);

    void onNoteAdded();

    void onDataNotAvailable();

}
