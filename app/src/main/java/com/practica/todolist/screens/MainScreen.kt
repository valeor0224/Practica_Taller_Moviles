package com.practica.todolist.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun MainScreen(myList: MutableState<List<String>>){
    Box(modifier = Modifier
        .fillMaxSize(),
        contentAlignment = Alignment.Center
    ){
        LazyColumn {
            // Display task details
            items(myList.value.size) { index ->
                val item = myList.value[index]

                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(10.dp)
                ) {
                    Text(
                        text = item,
                        modifier=Modifier
                            .padding(10.dp)
                    )
                    Button(
                        onClick = { /* Handle button click here */ },
                        colors = ButtonDefaults.buttonColors(Color.Red)
                    ) {
                        Icon(Icons.Default.Edit, contentDescription = "Edit")
                        Text("Edit")
                    }
                }


            }


        }
    }
}


