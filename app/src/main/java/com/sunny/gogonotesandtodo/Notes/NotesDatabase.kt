package com.sunny.gogonotesandtodo.Notes

import androidx.room.Database
import androidx.room.RoomDatabase

import androidx.room.TypeConverters
import com.sunny.gogonotesandtodo.Utilities.Converters

@Database(version = 1, entities = [NotesDataClass::class])
@TypeConverters(Converters::class)
abstract class NotesDatabase : RoomDatabase(){

    companion object{
        const val NAME = "Notes_DB"
    }

    abstract fun getNotesDao(): NotesDAO
}