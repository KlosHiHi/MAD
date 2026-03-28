package com.example.jetpackcompose.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Preview(showBackground = true)
@Composable
fun Auth(modifier: Modifier = Modifier) {
    var login by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    Column(
        modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        OutlinedTextField(
            login,
            { login = it },
            label = { Text("Логин") },
            placeholder = { Text("Логин") })
        OutlinedTextField(
            password, { password = it },
            label = { Text("Пароль") },
            placeholder = { Text("Пароль") })
        Button({}) {
            Text("Авторизоваться")
        }
    }
}