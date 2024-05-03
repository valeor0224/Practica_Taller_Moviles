package com.practica.todolist.components.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Settings
import androidx.compose.ui.graphics.vector.ImageVector

data class NavItems(
    val label : String,
    val icon: ImageVector,
    val route: String
)

val listOfNavigateItems = listOf(
    NavItems(
        label = "Home",
        icon = Icons.Default.Home,
        route = ScreenRoutes.MainScreen.route
    ),
    NavItems(
        label = "Profile",
        icon = Icons.Default.AccountCircle,
        route = ScreenRoutes.ProfileScreen.route
    ),
    NavItems(
        label = "Settings",
        icon = Icons.Default.Settings,
        route = ScreenRoutes.SettingsScreen.route
    )
)