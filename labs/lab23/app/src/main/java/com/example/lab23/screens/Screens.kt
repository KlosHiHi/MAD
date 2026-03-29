package com.example.lab23.screens

import android.graphics.drawable.shapes.RoundRectShape
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.outlined.Email
import androidx.compose.material.icons.outlined.Info
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Preview(showBackground = true)
@Composable
fun MainScreen() {
    Column(Modifier.fillMaxSize()) {
        Row(Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
            var searchText by remember { mutableStateOf("") }
            IconButton({}, modifier = Modifier.size(55.dp).padding(5.dp)) {
                Icon(Icons.Default.AccountCircle, "", modifier = Modifier.size(50.dp))
            }
            OutlinedTextField(
                searchText,
                { searchText = it },
                modifier = Modifier.size(230.dp, 50.dp),
                placeholder = { Text("Поиск") },
                label = { Text("Поиск") },
                leadingIcon = { Icon(Icons.Default.Search, "") })
            IconButton({}, modifier = Modifier.size(55.dp).padding(5.dp)) {
                Icon(Icons.Outlined.Email, "", modifier = Modifier.size(50.dp))
            }
            IconButton({}, modifier = Modifier.size(55.dp).padding(5.dp)) {
                Icon(Icons.Outlined.Info, "", modifier = Modifier.size(50.dp))
            }
        }

        Row(Modifier.fillMaxWidth().padding(10.dp, 50.dp), verticalAlignment = Alignment.CenterVertically) {
            Box(
                modifier = Modifier.padding(5.dp).border(3.dp, Color.Black)
                    .background(Color(0xFF8fce00)).size(120.dp).clickable{}
            ) {
                Icon(Icons.Default.Star, "", modifier = Modifier.size(60.dp).padding(5.dp))
                Text("0 руб.", modifier = Modifier.align(Alignment.BottomStart).padding(5.dp), fontSize = 20.sp)
            }
            Box(
                modifier = Modifier.padding(5.dp).border(3.dp, Color.Black)
                    .background(Color(0xFF8fce00)).alpha(40f).size(120.dp).clickable{}
            ) {

            }
            Column() {
                Box(
                    modifier = Modifier.padding(5.dp).border(3.dp, Color.Black)
                        .background(Color(0xFF8fce00)).size(50.dp).clickable{}
                ) {

                }
                Box(
                    modifier = Modifier.padding(5.dp).border(3.dp, Color.Black)
                        .background(Color(0xFF8fce00)).size(50.dp).clickable{}
                ) {

                }
            }
            Column() {
                Box(
                    modifier = Modifier.padding(5.dp).border(3.dp, Color.Black)
                        .background(Color(0xFF8fce00)).size(50.dp).clickable{}
                ) {

                }
                Box(
                    modifier = Modifier.padding(5.dp).border(3.dp, Color.Black)
                        .background(Color(0xFF8fce00)).size(50.dp).clickable{}
                ) {

                }
            }
        }
        Row(Modifier.fillMaxWidth().padding(10.dp, 0.dp), verticalAlignment = Alignment.CenterVertically) {
            Box(
                modifier = Modifier.padding(5.dp).fillMaxWidth().size(80.dp)
                    .background(Color(0xFF8fce00)).clickable {}
            ) {

            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun SavingScreen(){
    Column(modifier = Modifier.fillMaxSize()) {
        Text("Накопления", fontSize = 20.sp)
    }
}

@Preview(showBackground = true)
@Composable
fun PaymentScreen(){
    Column(modifier = Modifier.fillMaxSize()) {
        Text("Платежи", fontSize = 20.sp)

    }
}

@Preview(showBackground = true)
@Composable
fun CreditScreen(){
    Column(modifier = Modifier.fillMaxSize()) {
        Text("Кредиты", fontSize = 20.sp)
    }
}