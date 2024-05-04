package com.practica.todolist.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
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
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun AddTaskScreen(
    navController: NavController,
    myList: MutableState<List<String>>
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .padding(20.dp)
            .fillMaxWidth()
    ) {

        val task: MutableState<String> = remember {
            mutableStateOf("")
        }

        /* val listatasks: MutableState<List<String>> = remember {
             myList
         }*/

        Text(text = "Añadir tarea")
        OutlinedTextField(
            value = task.value,
            onValueChange = { newValue -> task.value = newValue },
            label = { Text("tarea") },
        )
        Row() {
            Button(
                onClick = {
                    //listatasks.add(task.value)
                    myList.value = myList.value + task.value
                    task.value = ""
                }
            ) {
                Text(text = "Añadir")
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

