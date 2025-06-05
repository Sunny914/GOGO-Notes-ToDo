package com.sunny.gogonotesandtodo

import android.app.Application
import androidx.room.Room
import androidx.room.RoomDatabase
import com.sunny.gogonotesandtodo.DB.NotesDatabase
import com.sunny.gogonotesandtodo.DB.TodoDatabase

class MainApplication : Application(){

    companion object{
        lateinit var todoDatabase: TodoDatabase
        lateinit var notesDatabase: NotesDatabase
    }

    override fun onCreate() {
        super.onCreate()
        todoDatabase = Room.databaseBuilder(
            applicationContext,
            TodoDatabase::class.java,
            TodoDatabase.NAME
        ).build()


        notesDatabase = Room.databaseBuilder(
            applicationContext,
            NotesDatabase::class.java,
            "notesdatabase"
        ).allowMainThreadQueries()
            .build()

    }
}