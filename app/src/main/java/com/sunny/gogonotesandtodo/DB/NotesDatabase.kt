package com.sunny.gogonotesandtodo.DB

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.LocalDate

@Entity(tableName = "note")
data class NotesDatabase(
    @PrimaryKey(autoGenerate = true)
    val id : Int,
    val title : String,
    val subtitle : String,
    val time : Long = System.currentTimeMillis(),
    val date : LocalDate = LocalDate.now()
)
