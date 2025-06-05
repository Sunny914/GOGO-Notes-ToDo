package com.sunny.gogonotesandtodo.BottomNavigation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material3.Icon
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.sunny.gogonotesandtodo.Notes.NotesScreen
import com.sunny.gogonotesandtodo.Todo.TodoListPage
import com.sunny.gogonotesandtodo.Todo.TodoViewModel

@Composable
fun BottomNavigation(modifier: Modifier = Modifier, todoViewModel: TodoViewModel, navController: NavController) {



    val navItemList = listOf (
        NavItem("TODO", Icons.Default.CheckCircle),
        NavItem("NOTES", Icons.Default.DateRange),
        )

    var selectedIndex by remember {
        mutableStateOf(0)
    }

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        bottomBar = {
            NavigationBar {
                navItemList.forEachIndexed { index, navItem ->
                    NavigationBarItem(
                        selected = selectedIndex == index,
                        onClick = {
                            selectedIndex = index
                        },
                        icon = {
                            Icon(imageVector = navItem.icon, contentDescription = "Icon")
                        },
                        label = {
                            Text(text = navItem.label)
                        }
                    )
                }
            }
        }
    ) { innerPadding ->
        ContentScreen(modifier = Modifier.padding(innerPadding), selectedIndex, todoViewModel, navController)

    }

}


    //val todoViewModel = ViewModelProvider(this)[TodoViewModel::class.java]

    @Composable
    fun ContentScreen(modifier: Modifier = Modifier, selectedIndex : Int, todoViewModel: TodoViewModel, navController: NavController){

        when(selectedIndex){
            0-> TodoListPage(todoViewModel)
            1-> NotesScreen(navController)
        }
    }

