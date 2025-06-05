package com.sunny.gogonotesandtodo.DB

import android.icu.text.CaseMap.Title
import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface NotesDAO {
    @Query(value = "select * from note")
    fun getNotes(): LiveData<List<NotesDatabase>>

    @Insert
    fun addNotes(note : NotesDatabase)

    @Query(value = "update note set title = :title, subtitle = :subtitle where id = :id ")
    fun updateNotes(title: String, subtitle : String, id : Int)

    @Query("delete from note where id = :id")
    fun deleteNote(id : Int)

}