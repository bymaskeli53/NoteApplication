package com.example.noteapplication

import androidx.room.Query
import javax.inject.Inject

class NoteRepository @Inject constructor(
    private val dao: NoteDao
) {

    suspend fun insertNoteToRoom(note: Note): Long = dao.insertNote(note)

    suspend fun getAllNotesFromRoom() : List<Note> = dao.getAllNotes()

    suspend fun getNumberOfNotesFromRoom(): Int = dao.numberOfNotesInDb()





//            @Insert(onConflict = OnConflictStrategy.REPLACE)
//            suspend fun insertNote(note: Note): Long
//
//    @Query("SELECT * FROM notes")
//    suspend fun getAllNotes(): List<Note>
//
//    @Query("SELECT COUNT(id) FROM notes")
//    suspend fun numberOfNotesInDb(): Int
}