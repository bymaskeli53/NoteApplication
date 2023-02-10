package com.example.noteapplication

import androidx.room.*


@Dao
interface NoteDao {


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertNote(note: Note): Long

    @Query("SELECT * FROM notes")
    suspend fun getAllNotes(): List<Note>

    @Query("SELECT COUNT(id) FROM notes")
    suspend fun numberOfNotesInDb(): Int




}