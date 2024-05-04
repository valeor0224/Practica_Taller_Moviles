package com.practica.todolist.components.navigation

sealed class ScreenRoutes(var route: String) {
    object  MainScreen : ScreenRoutes("home")
    object  ProfileScreen : ScreenRoutes("profile")
    object  SettingsScreen : ScreenRoutes("settings")
    object AddTaskScreen: ScreenRoutes("add_task")
    object EditTaskScreen:ScreenRoutes("edit_task")
}

