package com.example.labwork15.screens

import android.R
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Create
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldColors
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.launch

enum class Screens{
    AUTH_SCREEN,
    REG_SCREEN,
    USER_PROFILE_SCREEN
}

@Composable
fun Authorization(onReg: (Screens) -> Unit, onProfile: (Screens) -> Unit) {
    var login by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    Column(
        Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Icon(Icons.Filled.FavoriteBorder, "", modifier = Modifier.size(150.dp))


        OutlinedTextField(
            login, { login = it },
            label = { Text("Логин") },
            placeholder = { Text("Логин") },
            colors = TextFieldDefaults.colors(focusedContainerColor = Color(0xFF1EDD9C))
        )
        OutlinedTextField(
            password,
            { password = it },
            label = { Text("Пароль") },
            placeholder = { Text("Пароль") },
            colors = TextFieldDefaults.colors(focusedContainerColor = Color(0xFF1EDD9C))
        )
        Button({ onProfile(Screens.REG_SCREEN) }) {
            Text("Войти")
        }
        Button(
            { onReg(Screens.USER_PROFILE_SCREEN) },
            colors = ButtonDefaults.buttonColors(Color.Blue, Color.Cyan)
        ) {
            Text("Зарегистрироваться")
        }
    }
}

@Composable
fun Registration(onAuth: (Screens) -> Unit) {
    var login by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var repPassword by remember { mutableStateOf("") }
    var phone by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var age by remember { mutableStateOf("") }

    Column(
        Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Icon(Icons.Filled.Create, "", modifier = Modifier.size(150.dp))

        OutlinedTextField(
            login, { login = it },
            label = { Text("Логин") },
            placeholder = { Text("Введите логин...") },
            colors = TextFieldDefaults.colors(focusedContainerColor = Color(0xFF1EDD9C))
        )
        OutlinedTextField(
            password,
            { password = it },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            label = { Text("Пароль") },
            placeholder = { Text("Введите пароль...") },
            colors = TextFieldDefaults.colors(focusedContainerColor = Color(0xFF1EDD9C))
        )
        OutlinedTextField(
            repPassword,
            { repPassword = it },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            label = { Text("Подтверждение пароль") },
            placeholder = { Text("Подтвердите пароль") },
            colors = TextFieldDefaults.colors(focusedContainerColor = Color(0xFF1EDD9C))
        )
        OutlinedTextField(
            phone, { phone = it },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone),
            label = { Text("Номер телефона") },
            placeholder = { Text("Введите номер телефона...") },
            colors = TextFieldDefaults.colors(focusedContainerColor = Color(0xFF1EDD9C))
        )
        OutlinedTextField(
            email, { email = it },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
            label = { Text("E-mail") },
            placeholder = { Text("Введите e-mail...") },
            colors = TextFieldDefaults.colors(focusedContainerColor = Color(0xFF1EDD9C))
        )
        OutlinedTextField(
            age, { age = it },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            label = { Text("Возраст") },
            placeholder = { Text("Введите возраст...") },
            colors = TextFieldDefaults.colors(focusedContainerColor = Color(0xFF1EDD9C))
        )
        Button(
            { onAuth(Screens.AUTH_SCREEN) },
            colors = ButtonDefaults.buttonColors(Color.Blue, Color.Cyan)
        ) {
            Text("ОК")
        }
    }
}

@Composable
fun UserProfile(onAuth: (Screens) -> Unit) {
    val scrollState = rememberScrollState()
    Column(
        Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Icon(Icons.Filled.AccountCircle, "", modifier = Modifier.size(150.dp))

        Row(Modifier, verticalAlignment = Alignment.CenterVertically) {
            Text("Логин", fontSize = 25.sp, modifier = Modifier.padding(5.dp))
            Text("ХХ лет.", fontSize = 20.sp, modifier = Modifier.padding(5.dp, 0.dp))
        }
        Text("Фамилия Имя Отчество", fontSize = 20.sp)
        Text(
            "mail@example.com",
            fontSize = 20.sp,
            modifier = Modifier.padding(0.dp, 15.dp).padding(3.dp)
        )
        Text(
            "Это очень длинный текст, который должен переноситься на несколько строк с информацией о пользователе." +
                    "Это очень длинный текст, который должен переноситься на несколько строк с информацией о пользователе." +
                    "Это очень длинный текст, который должен переноситься на несколько строк с информацией о пользователе.",
            softWrap = true,
            fontSize = 20.sp,
            modifier = Modifier.border(2.dp, Color.Black).height(70.dp).padding(3.dp).verticalScroll(scrollState)
        )
        Button(
            { onAuth(Screens.AUTH_SCREEN) },
            colors = ButtonDefaults.buttonColors(Color.Blue, Color.Cyan)
        ) {
            Text("Назад")
        }
    }
}
