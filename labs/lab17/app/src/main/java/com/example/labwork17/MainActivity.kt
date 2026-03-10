package com.example.labwork17

import android.os.Bundle
import android.widget.Button
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Outline
import androidx.compose.ui.layout.ModifierLocalBeyondBoundsLayout
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.labwork17.ui.theme.Labwork17Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Labwork17Theme {
                TextFieldAboutUser()
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun RegistrationPage() {
    var login by remember{ mutableStateOf("") }
    var password by remember{ mutableStateOf("") }
    var passwordConfirmation by remember{ mutableStateOf("") }
    var phone by remember{ mutableStateOf("") }
    var email by remember{ mutableStateOf("") }
    var age by remember{ mutableStateOf("") }
    var personalSite by remember{ mutableStateOf("") }

    val text = remember{mutableStateOf("")}

    Column(Modifier.fillMaxSize().fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
        OutlinedTextField(value = login,
            onValueChange = {login = it},
            label = {Text("Логин")},
            placeholder = {Text("Введите логин")},
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text))

        OutlinedTextField(value = password,
            onValueChange = {password = it},
            label = {Text("Пароль")},
            placeholder = {Text("Введите пароль")},
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password))

        OutlinedTextField(value = passwordConfirmation,
            onValueChange = {passwordConfirmation = it},
            label = {Text("Подтвердите пароль")},
            placeholder = {Text("Введите пароль")},
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password))

        OutlinedTextField(value = phone,
            onValueChange = {phone = it},
            label = {Text("Телефон")},
            placeholder = {Text("Введите телефон")},
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone))

        OutlinedTextField(value = email,
            onValueChange = {email = it},
            label = {Text("Почта")},
            placeholder = {Text("Введите почту")},
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email))

        OutlinedTextField(value = age,
            onValueChange = {age = it},
            label = {Text("Возраст")},
            placeholder = {Text("Введите возраст")},
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number))

        OutlinedTextField(value = personalSite,
            onValueChange = {personalSite = it},
            label = {Text("Персональный сайт")},
            placeholder = {Text("Введите адрес сайта")},
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Uri))


        Button(onClick = { text.value = "$login, вы зарегистрированы" })
        { Text("Зарегитрироваться") }

        Text(text.value)
    }
}

@Preview(showBackground = true)
@Composable
fun PinPage(){
    var pin by remember{mutableStateOf("")}
    val correctPin = "3214"
    var tryCount by remember { mutableStateOf(3) }
    var isEnabled by remember { mutableStateOf(true) }
    val text = remember { mutableStateOf("") }

    Column(Modifier.fillMaxSize().fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally) {

        OutlinedTextField(pin,
            {pin = if(it.length > 4) pin else it},
            label = {Text("PIN-код")},
            placeholder = {Text("Введите PIN-код")},
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            )

        Button(onClick = {
            if(pin == correctPin) {
                text.value = "Верно"
                tryCount = 3
            }
            else {
                text.value = "Неверно"
                tryCount--
            }

            if(tryCount==0) {
                isEnabled = false
            }
         }, content = {Text("Отправить")}, enabled = isEnabled)

        Text("осталось: $tryCount попытки(-ок)")
        Text(text.value, fontSize = 30.sp)

    }
}

@Preview(showBackground = true)
@Composable
fun TextFieldAboutUser(){
    var text by remember { mutableStateOf("") }
    var availableChar by remember { mutableStateOf(300) }
    var maxChar = 300
    Column(Modifier.fillMaxSize().fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally) {

        OutlinedTextField(text,
            {
                text = if(it.length > 300) text
                else { availableChar = maxChar - it.length; it }
            },
            modifier = Modifier.width(350.dp).offset(y = 50.dp),
            label = {Text("Опишите себя")},
        )

        Text("осталось символов: $availableChar", modifier = Modifier.offset(y = 50.dp))
    }
}