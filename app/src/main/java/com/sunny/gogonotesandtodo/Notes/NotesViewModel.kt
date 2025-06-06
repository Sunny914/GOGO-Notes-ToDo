package com.sunny.gogonotesandtodo.Notes

import android.provider.ContactsContract.CommonDataKinds.Note
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import com.sunny.gogonotesandtodo.MainApplication
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.time.Instant
import java.util.Date

class NotesViewModel : ViewModel() {

    val notesDAO = MainApplication.notesDatabase.getNotesDao()
    val notesList : LiveData<List<NotesDataClass>> = notesDAO.getNotes()
    //var notesList : MutableList<NotesDataClass> = mutableListOf()

    fun getNotes(){
      //  notesList = notesDAO.getNotes().toMutableList()
    }

    fun addNotes(title : String, subtitle : String){
        //notesDAO.addNotes(notes)
        viewModelScope.launch(Dispatchers.IO) {
            notesDAO.addNotes(NotesDataClass(title = title, subtitle = subtitle, createdAt = Date.from(
                Instant.now())))
        }
    }

    fun deleteNotes(id : Int){
        viewModelScope.launch(Dispatchers.IO) {
            notesDAO.deleteNote(id)
        }
    }

    fun editNote(id: Int, newTitle: String, newSubtitle: String = newTitle) {
        viewModelScope.launch(Dispatchers.IO) {
            notesDAO.updateNote(id, newTitle, newSubtitle)
        }
    }

}