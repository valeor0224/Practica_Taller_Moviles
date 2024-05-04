package com.practica.todolist.model

import java.time.LocalDate

data class TaskData(
    val id: Int,
    val taskTitle:String,
    val taskDescription:String,
    val taskDate:LocalDate
)
