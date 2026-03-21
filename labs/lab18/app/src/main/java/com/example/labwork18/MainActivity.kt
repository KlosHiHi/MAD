package com.example.labwork18

import android.R
import android.os.Bundle
import android.provider.Contacts
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Build
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.Checkbox
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.traceEventEnd
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.labwork18.ui.theme.Labwork18Theme
import kotlinx.serialization.descriptors.PrimitiveKind
import kotlin.random.Random

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Labwork18Theme {
                Scaffold( bottomBar = {
                    Text("")
                }) { innerPadding ->
//                    Buttons(Modifier.padding(innerPadding))
//                    ProductsOne(Modifier.padding(innerPadding))
////                    Product()
//                    Contacts(Modifier.padding(innerPadding))
                    Tasks(Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun Buttons(modifier: Modifier = Modifier) {
    var color by remember { mutableStateOf(Color.Green) }
    var count by remember { mutableStateOf(0) }
    Column(modifier) {
        Row(Modifier.fillMaxWidth()) {
            Button(onClick = {count++}) { Text("123") }
            OutlinedButton(onClick = {count++}) { Text("123") }
            TextButton(onClick = {count++}) { Text("123") }
        }

        Row(Modifier.fillMaxWidth()) {
            Button(onClick = {count++}, shape = RoundedCornerShape(0)) { }
            Button(onClick = {count++}, shape = RoundedCornerShape(30)) { }
            Button(onClick = {count++}, shape = RoundedCornerShape(50)) { }
        }

        Row(Modifier.fillMaxWidth()) {
            Button(onClick = {
                count++
                val num = (0..4).random()
                color = when (num){
                    0 -> Color.Red
                    1 -> Color.Green
                    2 -> Color.Blue
                    3 -> Color.Magenta
                    4 -> Color.Yellow
                    else -> Color.Cyan
                }
            }, colors = ButtonDefaults.buttonColors(containerColor = color)) { }
        }

        Text("Вы накликали $count")
    }
}

@Preview(showBackground = true)
@Composable
fun ProductsOne(modifier: Modifier = Modifier){
    var count by remember { mutableStateOf(0) }
    var products = listOf("Значок Deltarune",
        "Брелок из акрила БойКиссер",
        "Игровая клавиатура проводная К821",
        )
    Scaffold( bottomBar = {
        Text("Товаров в корзине $count", textAlign = TextAlign.Center)
    }) { innerPadding ->
        Column(Modifier.padding(innerPadding)) {
            Row(modifier = Modifier.height(100.dp), verticalAlignment = Alignment.CenterVertically) {
                Text("Набор маркеров акриловых", fontSize = 15.sp)
                Button({
                    count++
                }) { Icon(Icons.Filled.ShoppingCart, "") }
            }
            Row(modifier = Modifier.height(100.dp), verticalAlignment = Alignment.CenterVertically) {
                Text("Значок кот-пришелец", fontSize = 15.sp)
                Button({
                    count++
                }) { Icon(Icons.Filled.ShoppingCart, "") }
            }
            Row(modifier = Modifier.height(100.dp), verticalAlignment = Alignment.CenterVertically) {
                Text("VXE игровая мышь", fontSize = 15.sp)
                Button({
                    count++
                }) { Icon(Icons.Filled.ShoppingCart, "") }
            }
            Row(modifier = Modifier.height(100.dp), verticalAlignment = Alignment.CenterVertically) {
                Text("Пиала для чая", fontSize = 15.sp)
                Button({
                    count++
                }) { Icon(Icons.Filled.ShoppingCart, "") }
            }
            Row(modifier = Modifier.height(100.dp), verticalAlignment = Alignment.CenterVertically) {
                Text("Слайм Антистресс Липтон Айс Ти", fontSize = 15.sp)
                Button({
                    count++
                }) { Icon(Icons.Filled.ShoppingCart, "") }
            }
            Row(modifier = Modifier.height(100.dp), verticalAlignment = Alignment.CenterVertically) {
                Text("Конструктор 3D лаванда", fontSize = 15.sp)
                Button({
                    count++
                }) { Icon(Icons.Filled.ShoppingCart, "") }
            }
            Row(modifier = Modifier.height(100.dp), verticalAlignment = Alignment.CenterVertically) {
                Text("Чёрная подвеска в виде кошки", fontSize = 15.sp)
                Button({
                    count++
                }) { Icon(Icons.Filled.ShoppingCart, "") }
            }
            Row(modifier = Modifier.height(100.dp), verticalAlignment = Alignment.CenterVertically) {
                Text("Акксесуар для бижутерии", fontSize = 15.sp)
                Button({
                    count++
                }) { Icon(Icons.Filled.ShoppingCart, "") }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun Product(){
    var count by remember { mutableStateOf(0) }
    var isMin by remember { mutableStateOf(false) }
    var isMax by remember { mutableStateOf(true) }
    val price = 100
    Column(Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Icon(Icons.Filled.Build,"", modifier = Modifier.size(150.dp))
            Text("Антистресс мялка - липтон айс ти", fontSize = 20.sp)
            Text("Количество: $count")
        }

        Row(verticalAlignment = Alignment.CenterVertically) {
            Text("${price*count} руб.")
            IconButton({
                count++;
                if(count>0)
                    isMin = true
                if(count == 10) {
                    isMax = false
                }
            }, enabled = isMax) {
                Icon(Icons.Filled.Add, "")
            }

            IconButton({
                count--;
                if (count == 0){
                    count = 0
                    isMin = false
                    isMax = true
                }
            }, enabled = isMin) { Icon(Icons.Filled.Delete, "") }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun Contacts(modifier: Modifier = Modifier) {
    var contacts = listOf(
        "79217870000",
        "89410000700",
        "89210005600",
        "79310000000",
        "89210005700",
        "89210880000",
        "89210000000",
        "89210032000",
        "89210090000",
        "89210000120",
        "89210023000",
        "89210000320",
        "89210545000",
        "89210000340",
        "89210334000",
        "89210000000",
        "89210000000",
        "89210320400",
        "89210000000",
        "89210000000",
        "89210000000",
        "89210088000",
        "89210000000",
        "89210000000",
        "89213230000",
        "89213230000",
        "89213230000",
        "89213230000",
        "89213230000",
    )

    Box(modifier) {
        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            items(contacts) { contact ->
                Text(
                    contact, fontSize = 50.sp,
                    modifier = Modifier.padding(5.dp).clickable{}
                )
            }
        }

        FloatingActionButton(
            {},
            modifier = Modifier.align(Alignment.BottomEnd)
                .padding(10.dp, 20.dp)
        ) {
            Icon(Icons.Filled.Call, "")
        }
        FloatingActionButton(
            {},
            modifier = Modifier.align(Alignment.BottomStart)
                .padding(10.dp, 20.dp)
        ) {
            Icon(Icons.Filled.Email, "")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun Tasks(modifier: Modifier = Modifier){
    var tasks = remember { mutableStateListOf("Пробная задача") }
    var count = 1
    Box(modifier) {
        LazyColumn(Modifier.fillMaxSize()) {
            items(tasks) { task ->
                Row(verticalAlignment = Alignment.CenterVertically) {
                    var status by remember { mutableStateOf(false) }
                    Text(task, fontSize = 30.sp)
                    Checkbox(checked = status,
                        onCheckedChange = { status = !status })
                }
            }
        }

        ExtendedFloatingActionButton(
            icon = {
                Icon(Icons.Filled.Add, "")
            },
            text = { Text("Добавить") },
            onClick = {tasks.add("Задача #$count"); count++},
            modifier = Modifier.align(Alignment.BottomEnd)
                .padding(10.dp, 20.dp),

        )
    }
}