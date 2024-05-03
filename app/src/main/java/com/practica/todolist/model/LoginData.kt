package com.practica.todolist.model

data class LoginData(
    var login: String = "",
    var pwd: String = "",
    var remember: Boolean = false
){
    fun isNotEmpty(): Boolean {
        return login.isNotEmpty() && pwd.isNotEmpty()
    }
}