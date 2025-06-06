package com.sunny.gogonotesandtodo.NavController

sealed class Routes(val routes: String) {
    object NotesScreen : Routes("notesScreen")
    object TodoScreen : Routes("todoScreen")
    object BottomNavigation : Routes("bottomNavigation")
    object AddNotesScreen : Routes("addNotesScreen")

    fun AddNotesScreenWithId(id: Int) = "addNotesScreen/$id"

    data class Screen(val routes: String)
}