package com.example.noteapplication

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "notes")
data class Note(
    var title: String,
    var note: String,
    @PrimaryKey(autoGenerate = true)
    var id: Int? = null

)
