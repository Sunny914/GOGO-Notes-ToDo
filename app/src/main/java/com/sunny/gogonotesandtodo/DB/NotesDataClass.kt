package com.sunny.gogonotesandtodo.DB

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.LocalDate
import java.util.Date

@Entity(tableName = "note")
data class NotesDataClass(
    @PrimaryKey(autoGenerate = true)
    val id : Int=0,
    val title : String,
    val subtitle : String,
    var createdAt : Date
   // val time : Long = System.currentTimeMillis(),
    //val date : LocalDate = LocalDate.now()
)
