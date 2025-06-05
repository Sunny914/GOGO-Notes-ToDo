package com.sunny.gogonotesandtodo.DB

import androidx.room.Dao
import androidx.room.Database
import androidx.room.RoomDatabase

import androidx.room.TypeConverters

@Database(version = 1, entities = [NotesDataClass::class])
@TypeConverters(Converters::class)
abstract class NotesDatabase : RoomDatabase(){

    companion object{
        const val NAME = "Notes_DB"
    }

    abstract fun getNotesDao(): NotesDAO
}