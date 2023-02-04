package com.example.noteapplication

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class NoteViewModel @Inject constructor(
    private val repository: NoteRepository
) : ViewModel() {

    suspend fun insertNoteToRoom(note: Note): Long = repository.insertNoteToRoom(note)

    suspend fun getAllNotesFromRoom(): List<Note> = repository.getAllNotesFromRoom()

    suspend fun getNumberOfNotesFromRoom(): Int = repository.getNumberOfNotesFromRoom()


}