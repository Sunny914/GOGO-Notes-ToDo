package com.sunny.gogonotesandtodo

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
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
import androidx.room.util.appendPlaceholders
import com.sunny.gogonotesandtodo.ui.theme.body
import com.sunny.gogonotesandtodo.ui.theme.ctaColor
import com.sunny.gogonotesandtodo.ui.theme.textColor

@Composable
fun NotesScreen(){
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



@Composable
fun AddScreen(){
    Column(
        Modifier
            .background(body)
            .padding(top = 32.dp)
            .padding(horizontal = 24.dp)
    ) {
       Text(
           text = "Notes++",
           Modifier.fillMaxWidth().wrapContentHeight(),
           fontSize = 24.sp,
           fontWeight = FontWeight.SemiBold,
           textAlign = TextAlign.Center
       )
        TextField(
            value = "",
            onValueChange = {

            },
            Modifier
                .padding(top = 30.dp)
                .fillMaxWidth()
                .clip(RoundedCornerShape(12.dp))
                .border(
                width = 1.dp,
                color = Color.DarkGray,
                shape = RoundedCornerShape(12.dp)
            ),
            placeholder = {
                Text(text = "Enter your Title")
            },
            colors = TextFieldDefaults.colors(
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                focusedContainerColor = Color.White,
                unfocusedContainerColor = Color.White
            )
        )

        TextField(
            value = "",
            onValueChange = {

            },
            Modifier
                .padding(top = 30.dp)
                .fillMaxWidth()
                .heightIn(200.dp, 600.dp)
                .clip(RoundedCornerShape(12.dp))
                .border(
                    width = 1.dp,
                    color = Color.DarkGray,
                    shape = RoundedCornerShape(12.dp)
                ),
            placeholder = {
                Text(text = "Enter the Message")
            },
            colors = TextFieldDefaults.colors(
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                focusedContainerColor = Color.White,
                unfocusedContainerColor = Color.White
            )
        )
        Button(
            onClick = {

            },
            Modifier
                .padding(top = 20.dp)
                .fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(containerColor = ctaColor)
        ) {
            Text("SAVE")
        }
    }
}






