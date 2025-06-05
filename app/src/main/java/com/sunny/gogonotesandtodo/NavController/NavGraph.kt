package com.sunny.gogonotesandtodo.NavController

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.sunny.gogonotesandtodo.AddNotesScreen
import com.sunny.gogonotesandtodo.BottomNavigation
import com.sunny.gogonotesandtodo.NotesScreen
import com.sunny.gogonotesandtodo.TodoListPage
import com.sunny.gogonotesandtodo.TodoViewModel

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
            BottomNavigation(Modifier,todoViewModel)
        }

        composable(route = Routes.AddNotesScreen.routes){
            AddNotesScreen()
        }

    }

}