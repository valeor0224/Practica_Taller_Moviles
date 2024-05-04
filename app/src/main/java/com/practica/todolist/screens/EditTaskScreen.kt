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
fun EditTaskScreen(
    navController: NavController,
    index: Int,
    myList: MutableState<List<String>>
) {
    val navBackStackEntry = navController.currentBackStackEntry
    val arguments = navBackStackEntry?.arguments
    //val index = arguments?.getInt("index") ?: -1 // Default value if index is not provided

    val task: MutableState<String> = remember {
        mutableStateOf(myList.value.getOrNull(index) ?: "") ///new
    }
    // Assuming you have a list of tasks (similar to myList) accessible here
    // val taskToEdit = tasks.getOrNull(index)
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .padding(20.dp)
            .fillMaxWidth()
    ) {

        Text(text = "Editar tarea")
        OutlinedTextField(
            value = task.value,
            onValueChange = { newValue -> task.value = newValue },
            label = { Text("tarea") },
        )
        Row() {
            Button(
                onClick = {
                    // Update the task in the list
                    if (index in myList.value.indices) {
                        myList.value = myList.value.toMutableList().apply {
                            set(index, task.value)
                        }
                    }
                    // Navigate back
                    //navController.popBackStack()
                }
            ) {
                Text(text = "Save")
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