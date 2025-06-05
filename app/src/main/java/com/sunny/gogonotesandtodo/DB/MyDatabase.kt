package com.sunny.gogonotesandtodo.DB

import androidx.room.Dao
import androidx.room.Database
import androidx.room.TypeConverter
import androidx.room.TypeConverters

@Database(version = 1, entities = [NotesDatabase::class])
@TypeConverters(com.sunny.gogonotesandtodo.DB.TypeConverters::class)
abstract class MyDatabase {
    abstract fun getDao(): Dao
}