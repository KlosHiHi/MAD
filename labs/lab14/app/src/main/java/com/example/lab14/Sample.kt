package com.example.lab14

import androidx.compose.foundation.layout.offset
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp


class Sample {
    @Composable
    fun GreetingSample(){
        Greeting(name = "Android", modifier = Modifier.offset(10.dp))
    }

    @Composable
    fun GreetingPreviewSample(){
        GreetingPreview()
    }

    @Composable
    fun DivisionSample(){
        val result = division(3, 4)
    }

    @Composable
    fun UserLoginSample(){
        val user : UserLogin = UserLogin("login123", "pa22w0r!")
        if(user.checkPassword("paSSw0r!"))
            print("Успешный вход")
        else
            print("При попытке входа произошла ошибка")
    }
}