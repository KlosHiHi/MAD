package com.example.labwork20.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ModifierLocalBeyondBoundsLayout
import androidx.compose.ui.unit.sp

data class Product (val name: String, val price: Float)
var products = listOf<Product>(
    Product("Брелок акриловый", 10.0f),
    Product("Набор обложек", 15.0f),
    Product("Модель анатомическая", 65.4f),
    Product("Значок", 67.4f),
    Product("Фотоальбом", 10.3f),
    Product("Помидоры 1кг.", 78.5f),
    Product("Книга", 16.4f),
    Product("Бургер", 30.5f),
    Product("Кружка Хеллоу-Китти", 19.8f),
    Product("Набор наклеек", 20.5f),
)

@Composable
fun Auth(reg:() -> Unit, list: (List<Product>) -> Unit) {
    Column(
        Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        var login by remember { mutableStateOf("") }
        var password by remember { mutableStateOf("") }
        Text("Авторизация", fontSize = 25.sp)
        OutlinedTextField(
            login,
            {},
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = Color.Cyan,
                unfocusedBorderColor = Color.Black,
                focusedLabelColor = Color.DarkGray,
                unfocusedLabelColor = Color.LightGray,
                focusedContainerColor = Color.Cyan.copy(alpha = 0.1f),
                unfocusedContainerColor = Color.Transparent,
                cursorColor = Color.Blue,
            ),
            label = { Text("Логин") },
            placeholder = { Text("Логин") })
        OutlinedTextField(
            password,
            {},
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = Color.Cyan,
                unfocusedBorderColor = Color.Black,
                focusedLabelColor = Color.DarkGray,
                unfocusedLabelColor = Color.LightGray,
                focusedContainerColor = Color.Cyan.copy(alpha = 0.1f),
                unfocusedContainerColor = Color.Transparent,
                cursorColor = Color.Blue,
            ),
            label = { Text("Пароль") },
            placeholder = { Text("Пароль") })
        Button(
            { list.invoke(products) },
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Cyan,
                contentColor = Color.White
            ),
        ) { Text("Ок", fontSize = 18.sp) }
        Button(
            { reg.invoke() },
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Cyan,
                contentColor = Color.White
            ),
        ) { Text("Регистрация", fontSize = 18.sp) }
    }
}

@Composable
fun Register(auth:() -> Unit) {
    Column(
        Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        var login by remember { mutableStateOf("") }
        var password by remember { mutableStateOf("") }
        var repPassword by remember { mutableStateOf("") }
        Text("Регистрация", fontSize = 25.sp)
        OutlinedTextField(
            login,
            {},
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = Color.Cyan,
                unfocusedBorderColor = Color.Black,
                focusedLabelColor = Color.DarkGray,
                unfocusedLabelColor = Color.LightGray,
                focusedContainerColor = Color.Cyan.copy(alpha = 0.1f),
                unfocusedContainerColor = Color.Transparent,
                cursorColor = Color.Blue,
            ),
            label = { Text("Логин") },
            placeholder = { Text("Логин") })
        OutlinedTextField(
            password,
            {},
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = Color.Cyan,
                unfocusedBorderColor = Color.Black,
                focusedLabelColor = Color.DarkGray,
                unfocusedLabelColor = Color.LightGray,
                focusedContainerColor = Color.Cyan.copy(alpha = 0.1f),
                unfocusedContainerColor = Color.Transparent,
                cursorColor = Color.Blue,
            ),
            label = { Text("Пароль") },
            placeholder = { Text("Пароль") })
        OutlinedTextField(
            repPassword,
            {},
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = Color.Cyan,
                unfocusedBorderColor = Color.Black,
                focusedLabelColor = Color.DarkGray,
                unfocusedLabelColor = Color.LightGray,
                focusedContainerColor = Color.Cyan.copy(alpha = 0.1f),
                unfocusedContainerColor = Color.Transparent,
                cursorColor = Color.Blue,
            ),
            label = { Text("Повторите пароль") },
            placeholder = { Text("Повторите пароль") })
        Button(
            { auth.invoke() },
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Cyan,
                contentColor = Color.White
            ),
        ) { Text("Ок", fontSize = 18.sp) }
    }
}

@Composable
fun ProductList(products: List<Product>, tap:(Product) -> Unit) {
    Column(
        Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Список товаров", fontSize = 25.sp)
        LazyColumn() {
            items(products)
            { item ->
                Row(Modifier.clickable{tap.invoke(item)}) {
                    Text(item.name, fontSize = 25.sp)
                    Text(item.price.toString(), fontSize = 25.sp)
                }
            }
        }
    }
}

@Composable
fun ProductInfo(product: Product) {
    Column(
        Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Товар", fontSize = 30.sp)
        Text(product.name, fontSize = 25.sp)
        Text(product.price.toString(), fontSize = 20.sp)
    }
}