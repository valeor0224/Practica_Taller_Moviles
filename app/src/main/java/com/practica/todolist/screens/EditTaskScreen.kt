package com.practica.todolist.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun EditTaskScreen(
    navController: NavController,
    myList: MutableState<List<String>>,
    taskId: Int
){
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .padding(20.dp)
            .fillMaxWidth()
    ) {

        val task: MutableState<String> = remember {
            mutableStateOf(myList.value.getOrNull(taskId) ?: "") ///new
        }


        Text(text = "Editar tarea")
        OutlinedTextField(

            value = task.value,
            onValueChange = { newValue -> task.value = newValue },
            label = { Text("tarea") },
        )
        Row() {
            Button(
                onClick = {
                    // Update the existing task in the list
                    val updatedList = myList.value.toMutableList()
                    updatedList[taskId] = task.value
                    myList.value = updatedList
                    task.value = ""
                }
            ) {
                Text(text = "Save changes")
            }

            Button(
                onClick = { navController.popBackStack() },
                colors = ButtonDefaults.buttonColors(Color.Gray)
            ) {
                Text(text = "Go Back")
            }
        }

    }
}