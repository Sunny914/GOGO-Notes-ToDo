package com.sunny.gogonotesandtodo.Notes

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.sunny.gogonotesandtodo.NavController.Routes
import com.sunny.gogonotesandtodo.ui.theme.body
import com.sunny.gogonotesandtodo.ui.theme.ctaColor

@Composable
fun AddNotesScreen(viewModel: NotesViewModel, navController: NavController, noteId: Int = -1){

    var title by remember {
        mutableStateOf("")
    }

    var subtitle by remember {
        mutableStateOf("")
    }
//
//    LaunchedEffect(noteId) {
//        if(noteId != -1){
//            val existingNote = allNotes.find
//        }
//    }
//

    Column(
        Modifier
            .background(body)
            .padding(top = 32.dp)
            .padding(horizontal = 24.dp)
    ) {
        Text(
            text = "Add Notes",
            Modifier.fillMaxWidth().wrapContentHeight(),
            fontSize = 24.sp,
            fontWeight = FontWeight.SemiBold,
            textAlign = TextAlign.Center
        )
        TextField(
            value = title,
            onValueChange = {
                title = it
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
            value = subtitle,
            onValueChange = {
                subtitle = it
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
                viewModel.addNotes(title, subtitle)

                title = ""
                subtitle = ""

                navController.navigate(Routes.NotesScreen.routes){
                    popUpTo(Routes.AddNotesScreen.routes) {inclusive = true}
                }
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