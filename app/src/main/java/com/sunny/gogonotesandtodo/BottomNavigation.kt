package com.sunny.gogonotesandtodo

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material3.Icon
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.lifecycle.ViewModelProvider

@Composable
fun BottomNavigation(modifier: Modifier = Modifier, todoViewModel: TodoViewModel) {

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
        ContentScreen(modifier = Modifier.padding(innerPadding), selectedIndex, todoViewModel = TodoViewModel())

    }

}


    //val todoViewModel = ViewModelProvider(this)[TodoViewModel::class.java]

    @Composable
    fun ContentScreen(modifier: Modifier = Modifier, selectedIndex : Int, todoViewModel: TodoViewModel){
        when(selectedIndex){
            0-> TodoListPage(todoViewModel)
            1-> NotesScreen()
        }
    }

