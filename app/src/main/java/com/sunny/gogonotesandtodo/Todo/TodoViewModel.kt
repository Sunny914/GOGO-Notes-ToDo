package com.sunny.gogonotesandtodo.Todo

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sunny.gogonotesandtodo.MainApplication
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.time.Instant
import java.util.Date

class TodoViewModel : ViewModel() {


    val todoDao = MainApplication.todoDatabase.getTodoDao()

    val todoList : LiveData<List<Todo>> = todoDao.getAllTodo()


    fun addTodo(title : String){

        viewModelScope.launch(Dispatchers.IO){
            todoDao.addTodo(Todo(title = title, createdAt = Date.from(Instant.now())))
        }

    }

    fun deleteTodo(id : Int){
        viewModelScope.launch(Dispatchers.IO){
            todoDao.deleteTodo(id)
        }

    }
}