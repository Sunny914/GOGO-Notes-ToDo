package com.sunny.gogonotesandtodo.NavController

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.sunny.gogonotesandtodo.Notes.AddNotesScreen
import com.sunny.gogonotesandtodo.BottomNavigation.BottomNavigation
import com.sunny.gogonotesandtodo.Notes.NotesScreen
import com.sunny.gogonotesandtodo.Todo.TodoListPage
import com.sunny.gogonotesandtodo.Todo.TodoViewModel

@Composable
fun NavGraph(){
    val navController : NavHostController = rememberNavController()

    NavHost(navController = navController, startDestination = Routes.BottomNavigation.routes){

        composable(route = Routes.NotesScreen.routes){
            NotesScreen(navController)
        }

        composable(route = Routes.TodoScreen.routes){
            val todoViewModel : TodoViewModel = viewModel()
            TodoListPage(todoViewModel)
        }

        composable(route = Routes.BottomNavigation.routes){
            val todoViewModel : TodoViewModel = viewModel()
            BottomNavigation(Modifier,todoViewModel, navController)
        }

        composable(route = Routes.AddNotesScreen.routes){
            AddNotesScreen()
        }

    }

}