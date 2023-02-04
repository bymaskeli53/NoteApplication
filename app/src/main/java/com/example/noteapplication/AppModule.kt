package com.example.noteapplication

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule {



    @Singleton
    @Provides
    fun provideDatabase(
        @ApplicationContext context: Context
    ) : NoteDatabase = Room.databaseBuilder(
        context,
        NoteDatabase::class.java,
        "note_database"
    ).addMigrations(MIGRATION_1_2).build()

    @Singleton
    @Provides
    fun provideDao(db: NoteDatabase)  : NoteDao= db.getDao()
    
//    @Singleton
//    @Provides
//    fun provide


}