package com.example.noteapplication

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase


val MIGRATION_1_2 = object : Migration(1,2) {
    override fun migrate(database: SupportSQLiteDatabase) {
        database.execSQL("ALTER TABLE notes ADD COLUMN date TEXT NOT NULL DEFAULT A ")
    }
}

@Database(entities = [Note::class], version = 2)
abstract class NoteDatabase : RoomDatabase() {



    abstract fun getDao(): NoteDao
}