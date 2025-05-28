package com.sunny.gogonotesandtodo

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.Instant
import java.util.Date

@Entity
data class Todo(
    @PrimaryKey(autoGenerate = true)
    var id : Int = 0,
    var title : String,
    var createdAt : Date
)


/*fun getFaketodo(): List<Todo>{
    return listOf<Todo>(
        Todo(1,"First Todo", Date.from(Instant.now())),
        Todo(2,"Second Todo", Date.from(Instant.now())),
        Todo(3,"Third Todo", Date.from(Instant.now())),
        Todo(4,"This is my Fourth Todo so that I can use it in UI", Date.from(Instant.now())),
    )
}*/