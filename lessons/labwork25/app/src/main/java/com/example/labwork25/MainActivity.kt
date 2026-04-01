package com.example.labwork25

import android.R
import android.os.Bundle
import android.widget.Button
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.labwork25.ui.theme.Labwork25Theme
import kotlin.math.log

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Labwork25Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Column(Modifier.fillMaxSize().padding(innerPadding)){
//                        Eula()
                        StreamRead()
                    }
                }
            }
        }
    }
}

@Composable
fun Eula() {
    val context = LocalContext.current
    var isAllow by remember { mutableStateOf(false) }
    var eula by remember { mutableStateOf("") }
    LaunchedEffect(Unit) {
        eula = context.assets.open("eula.txt").bufferedReader().use { it.readText() }
    }
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text(eula);
        Row {
            Checkbox(isAllow, { isAllow = !isAllow })
            Text("Я прочитал условия лиценпaзионного хи хи соглашения", fontSize = 15.sp)
        }
        Button({}, enabled = isAllow) { Text("Принять") }
    }
}

@Composable
fun StreamRead() {
    val context = LocalContext.current
    var login by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var passwords by remember { mutableStateOf(listOf("")) }
    var isLogged by remember { mutableStateOf(false) }

    if (isLogged) {
        AlertDialog(
            { isLogged = !isLogged },
            title = {},
            text = { Text("Ваш пароль ненадёжный") },
            confirmButton = {
                IconButton({ isLogged = !isLogged }) {
                    Icon(Icons.Default.Check, "")
                }
            })
    }

    LaunchedEffect(Unit) {
        passwords =
            context.assets.open("weak_passwords.txt").bufferedReader().use { it.readLines() }
    }
    Column(modifier = Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally) {
        OutlinedTextField(
            login,
            { login = it },
            label = { Text("Логин") },
            placeholder = { Text("Логин") })
        OutlinedTextField(
            password,
            { password = it },
            label = { Text("Пароль") },
            placeholder = { Text("Пароль") })
        Button({
            isLogged = passwords.contains(password)
        }) {
            Text("Зарегистрироваться")
        }
    }
}

@Composable
fun Notes(){
    val context = LocalContext.current
    var title by remember { mutableStateOf("") }
    var text by remember { mutableStateOf("") }


    Column(Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally) {
        OutlinedTextField(
            title,
            { title = it },
            label = { Text("Заголовок") },
            placeholder = { Text("Заголовок") })

        OutlinedTextField(
            value = text,
            onValueChange = { text = it },
            modifier = Modifier.height(200.dp),
            label = { Text("Текст") },
            placeholder = { Text("Текст") })
    }
}