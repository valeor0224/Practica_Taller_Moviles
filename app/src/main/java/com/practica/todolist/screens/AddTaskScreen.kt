package com.practica.todolist.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun AddTaskScreen(navController:NavController){
    Box(modifier = Modifier
        .fillMaxSize(),
        contentAlignment = Alignment.Center
    ){
        Button(
            onClick = { navController.popBackStack() },
            colors = ButtonDefaults.buttonColors(Color.Gray)
        ) {
            Text(text = "Go Back")
        }

        Text(
            text = "Add Task Screen",
            fontFamily = FontFamily.SansSerif,
            fontSize = 22.sp
        )
    }
}