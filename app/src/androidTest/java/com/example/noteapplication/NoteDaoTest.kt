package com.example.noteapplication

import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.SmallTest
import com.google.common.truth.Truth.assertThat
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4


@RunWith(AndroidJUnit4::class)
@SmallTest
class NoteDaoTest {

    private lateinit var database: NoteDatabase
    private lateinit var noteDao: NoteDao

    @Before
    fun setupDatabase() {

        // we use inMemoryDatabaseBuilder because we want to build our test database in ram instead of persistance storage.

        database = Room.inMemoryDatabaseBuilder(
            ApplicationProvider.getApplicationContext(),
            NoteDatabase::class.java
        )
            .allowMainThreadQueries()
            .build()

        noteDao = database.getDao()


    }

    @After
    fun closeDatabase() {
        database.close()
    }

    @Test
    fun insertDatabase_returnsTrue() {
        runBlocking {
            val note = Note(
                title = "Test implementation",
                note = "Test will be implemented",
                id = 1,
                date = "10.02.2023"
            )
            noteDao.insertNote(note)
            val allNotes = noteDao.getAllNotes()

            assertThat(allNotes).contains(note)
        }



    }



}