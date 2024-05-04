package com.practica.todolist.components.navigation

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.practica.todolist.screens.MainScreen
import com.practica.todolist.screens.ProfileScreen
import com.practica.todolist.screens.SettingsScreen
// for a 'val' variable
import androidx.compose.runtime.getValue

// for a `var` variable also add
import androidx.compose.runtime.setValue
import androidx.navigation.NavController
import com.practica.todolist.screens.AddTaskScreen

@Composable
fun AppNavigation() {

    val navController = rememberNavController()

    var presses by remember { mutableStateOf(0) }
    val navBackStackEntry = navController.currentBackStackEntryAsState().value
    val currentDestination: NavDestination? = navBackStackEntry?.destination
    Scaffold(

        bottomBar = {
            NavigationBar {
                //val navBackStackEntry by navController.currentBackStackEntryAsState()


                listOfNavigateItems.forEach { navItems ->
                    NavigationBarItem(
                        selected = currentDestination?.hierarchy?.any { it.route == navItems.route } == true,
                        onClick = {
                            navController.navigate(navItems.route) {
                                popUpTo(navController.graph.findStartDestination().id) {
                                    saveState = true
                                }
                                launchSingleTop = true
                                restoreState = true

                            }
                        },
                        icon = {
                            Icon(imageVector = navItems.icon, contentDescription = null)
                        },
                        label = {
                            Text(text = navItems.label)
                        }
                    )
                }
            }
        },
        floatingActionButton = {
            val currentRoute = currentDestination?.route
            // Show the FAB only on the home screen
            if (currentRoute == "home") {
                FloatingActionButton(
                    onClick = {navController.navigate(ScreenRoutes.AddTaskScreen.route)}
                ) {
                    Icon(Icons.Default.Add, contentDescription = "Add")
                }
            }
        }

    ) { paddingValues ->
        NavHost(
            navController = navController,
            startDestination = ScreenRoutes.MainScreen.route,
            modifier = Modifier
                .padding(paddingValues)
        ) {
            composable(route = ScreenRoutes.MainScreen.route) {
                MainScreen()
            }
            composable(route = ScreenRoutes.ProfileScreen.route) {
                ProfileScreen()
            }
            composable(route = ScreenRoutes.SettingsScreen.route) {
                SettingsScreen()
            }
            composable(route=ScreenRoutes.AddTaskScreen.route){
                AddTaskScreen(navController)
            }

        }

    }
}