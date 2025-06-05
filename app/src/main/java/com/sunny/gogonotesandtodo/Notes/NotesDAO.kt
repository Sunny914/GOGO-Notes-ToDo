package com.sunny.gogonotesandtodo.Notes

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface NotesDAO {
    @Query(value = "SELECT * FROM note")
    fun getNotes(): LiveData<List<NotesDataClass>>

    @Insert
    fun addNotes(note : NotesDataClass)

   // @Query(value = "update note set title = :title, subtitle = :subtitle where id = :id ")
    //fun updateNotes(title: String, subtitle : String, id : Int)

    @Query("DELETE FROM note where id = :id")
    fun deleteNote(id : Int)

}