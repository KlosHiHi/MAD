package com.example.jetpackcompose

import android.R
import android.os.Bundle
import android.widget.Button
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.modifier.modifierLocalOf
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jetpackcompose.ui.theme.JetpackComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            JetpackComposeTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        group = "ИСПП-31",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting(group: String, modifier: Modifier = Modifier) {
    Modifier.fillMaxSize()
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = "Привет $group!",
            fontSize = 30.sp,
            color = Color.Green
        )
    }
}

@Preview(showBackground = true)
@Composable
fun Task2Box(){

    Box {
        Modifier.fillMaxSize()
        Text(
            text = "Добро пожаловать",
            fontSize = 20.sp,
            color = Color.Black
        )
        Button(onClick = {}) {
            Text("OK")

        }
    }
}

@Preview(showBackground = true)
@Composable
fun Task2Row() {
    Row {
        Modifier.fillMaxSize()
        Text(
            text = "Добро пожаловать",
            fontSize = 20.sp,
            color = Color.Black
        )
        Button(onClick = {}) {
            Text("OK")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun Task2Column() {
    Column {

        Text(
            text = "Добро пожаловать",
            fontSize = 20.sp,
            color = Color.Black
        )
        Button(onClick = {}) {
            Text("OK")

        }
    }
}

@Preview(showBackground = true)
@Composable
fun Task2Design() {
    Box(Modifier.fillMaxSize()) {
        Box(
            Modifier
                .size(width = 100.dp, height = 100.dp)
                .background(Color.Red)
                .align(Alignment.TopStart)
        )
        Box(
            Modifier
                .size(width = 100.dp, height = 100.dp)
                .background(Color.Blue)
                .align(Alignment.TopCenter)
        )
        Box(
            Modifier
                .size(width = 100.dp, height = 100.dp)
                .background(Color.Yellow)
                .align(Alignment.TopEnd)
        )
        Box(
            Modifier
                .size(width = 100.dp, height = 100.dp)
                .background(Color.Green)
                .align(Alignment.CenterStart)
        )
        Box(
            Modifier
                .size(width = 100.dp, height = 100.dp)
                .background(Color.Magenta)
                .align(Alignment.CenterEnd)
        )
        Box(
            Modifier
                .size(width = 100.dp, height = 100.dp)
                .background(Color.Cyan)
                .align(Alignment.BottomStart)
        )
        Box(
            Modifier
                .size(width = 100.dp, height = 100.dp)
                .background(Color.LightGray)
                .align(Alignment.BottomCenter)
        )
        Box(
            Modifier
                .size(width = 100.dp, height = 100.dp)
                .background(Color.Gray)
                .align(Alignment.BottomEnd)
        )
        Box(
            modifier = Modifier
                .size(width = 300.dp, height = 750.dp)
                .background(Color.Black)
                .align(Alignment.Center)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun Task2DesignColumn() {
    Column(Modifier.fillMaxSize()) {
        Column(Modifier.weight(5f).fillMaxWidth().background(Color.Red)) {
            Text("5%")
        }
        Column(Modifier.weight(15f).fillMaxWidth().background(Color.Green)) {
            Text("15%")
        }
        Column(Modifier.weight(30f).fillMaxWidth().background(Color.Blue)) {
            Text("30%")
        }
        Column(Modifier.weight(50f).fillMaxWidth().background(Color.Yellow)) {
            Text("50%")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun Task5() {
    val items = listOf<String>("Мексика", "Германия", "Франция", "Россия", "США")

    Column(modifier = Modifier.fillMaxSize().padding(15.dp)) {
        items.forEach{ item ->
            Text(
                text = item,
                modifier = Modifier.padding(15.dp)
                    .background(Color.LightGray)
                    .fillMaxWidth(),
                textAlign = TextAlign.Center

            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Greeting("ИСПП-31")
    Task2Column()
    Task2Box()
    Task2Row()
}