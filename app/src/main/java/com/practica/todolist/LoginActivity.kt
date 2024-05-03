package com.practica.todolist

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.Surface
import androidx.compose.ui.platform.LocalContext
import com.practica.todolist.components.login.LoginFormComponent
import com.practica.todolist.ui.theme.ToDoListTheme


class LoginActivity: ComponentActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        enableEdgeToEdge()
        super.onCreate(savedInstanceState)
        setContent{
            ToDoListTheme {
                Surface {
                    val context = LocalContext.current
                    LoginFormComponent(context)
                }
            }

        }
    }
}