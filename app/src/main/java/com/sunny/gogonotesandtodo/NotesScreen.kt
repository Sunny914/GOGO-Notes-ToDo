package com.sunny.gogonotesandtodo

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box


import androidx.compose.foundation.layout.Column


import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.room.util.appendPlaceholders
import com.sunny.gogonotesandtodo.NavController.Routes
import com.sunny.gogonotesandtodo.ui.theme.body
import com.sunny.gogonotesandtodo.ui.theme.ctaColor
import com.sunny.gogonotesandtodo.ui.theme.textColor

@Composable
fun NotesScreen(navController: NavController){
    Box(
        modifier = Modifier.fillMaxSize()
    ){

        Column(
            Modifier.fillMaxSize()
                .background(body)
                .padding(horizontal = 24.dp)
                .padding(top = 32.dp)

        ){
            Row(
                Modifier.fillMaxWidth().wrapContentHeight()
            ) {
                Icon(Icons.Filled.Menu, contentDescription = "menu")
                Spacer(Modifier.weight(1f))
                Text(
                    text = "My Notes", Modifier,
                    fontWeight = FontWeight.Bold, fontSize = 24.sp,
                    fontFamily = FontFamily.Cursive,
                    color = Color.Black,
                )

                Spacer(Modifier.weight(1f))
                Icon(Icons.Filled.Search, contentDescription = "search")
            }

            LazyVerticalStaggeredGrid(
                columns = StaggeredGridCells.Fixed(2),
                Modifier.padding(top = 16.dp),
                verticalItemSpacing = 16.dp,
                horizontalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                items(5){
                    NotesContent()
                }
            }
        }

        Box(
            modifier = Modifier.align(Alignment.BottomEnd)
                .padding(bottom = 100.dp)
        ){
            FloatingActionButton(
                onClick = {navController.navigate(Routes.AddNotesScreen.routes)},
                modifier = Modifier
                    .align(Alignment.BottomEnd)
                    .padding(16.dp),
                containerColor = ctaColor,
                contentColor = Color.White
            ) {
                Icon(
                    Icons.Filled.Add,
                    contentDescription = "Add Note",
                    modifier = Modifier.size(24.dp)
                )
            }
        }
    }


}




@Composable
fun NotesContent(){
    Column(
       Modifier.wrapContentSize()
           .background(Color.White, RoundedCornerShape(12.dp))
           .padding(16.dp)
    ) {
        Text(text = "This is Sample Title", Modifier,
            fontWeight = FontWeight.Bold,
            color = textColor,
            fontSize = 18.sp
            )
        Text(text = "This is a Sample TextField of message",
            Modifier.padding(top = 5.dp) ,
            color = textColor
        )

        Row (Modifier.fillMaxWidth().wrapContentHeight()){
            Spacer(Modifier.weight(1f))
            Icon(Icons.Filled.MoreVert, contentDescription = null,
                Modifier.size(16.dp))
            DropdownMenu(
                expanded = false,
                onDismissRequest = {}
            ){
                DropdownMenuItem(text = {
                    Text(text = "edit")
                },
                    onClick = {

                    }
                )
                DropdownMenuItem(text = {
                    Text(text = "delete")
                },
                    onClick = {

                    }
                )
            }
        }
    }
}










