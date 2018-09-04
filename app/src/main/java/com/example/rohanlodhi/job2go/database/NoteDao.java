package com.example.rohanlodhi.job2go.database;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.example.rohanlodhi.job2go.models.Note;

import java.util.List;

import io.reactivex.Maybe;

@Dao
public interface NoteDao {

    @Query("SELECT * FROM notes")
    Maybe<List<Note>> getAll();

    @Insert
    void insertAll(Note... notes);

}