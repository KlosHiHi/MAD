package com.example.labwork22

import android.R
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Email
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.labwork22.ui.theme.Labwork22Theme
import kotlinx.coroutines.cancel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlin.random.Random

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Labwork22Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
//                    Circular(modifier = Modifier.padding(innerPadding))
//                    Linear(modifier = Modifier.padding(innerPadding))
                    BackTime(modifier = Modifier.padding(innerPadding))
//                    BadgeBoxTask(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun Circular(modifier: Modifier = Modifier) {
    var progress by remember { mutableStateOf(0f) }
    var isEnable by remember { mutableStateOf(false) }
    var scope = rememberCoroutineScope()

    Column(
        modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        if (isEnable) {
            CircularProgressIndicator(
                trackColor = Color.Black,
                color = Color.Magenta,
                progress = { progress },
                strokeCap = StrokeCap.Square,
                gapSize = 0.dp,
            )
        } else
            CircularProgressIndicator(
                trackColor = Color.Black,
                color = Color.Magenta,
            )

        Button({
            isEnable = true
            scope.launch {
                while (true) {
                    delay(1000)
                    if (progress < 1)
                        progress += 0.1f
                    else
                        break
                }
            }
        }) {
            Text("Скачать")
        }
    }
}

@Composable
fun Linear(modifier: Modifier = Modifier) {
    var progress1 by remember { mutableStateOf(0f) }
    var progress2 by remember { mutableStateOf(0f) }
    var progress3 by remember { mutableStateOf(0f) }
    var scope = rememberCoroutineScope()

    Column(
        modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("%.2f".format(progress1 * 100), fontSize = 20.sp)

        LinearProgressIndicator(
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp),
            progress = { progress1 },
            trackColor = Color.Red,
            color = Color.Green,
        )

        Text("%.2f".format(progress2 * 100), fontSize = 20.sp)
        LinearProgressIndicator(
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp),
            progress = { progress2 },
            trackColor = Color.Blue,
            color = Color.Green,
        )

        Text("%.2f".format(progress3 * 100), fontSize = 20.sp)
        LinearProgressIndicator(
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp),
            progress = { progress3 },
            trackColor = Color.Magenta,
            color = Color.Green,
        )

        Button({
            scope.launch {
                while (true) {
                    delay(100)
                    if (progress1 < 0.98)
                        progress1 += Random.nextFloat() / 10
                    else
                        progress1 = 1f
                    if (progress2 < 1)
                        progress2 += Random.nextFloat() / 10
                    else
                        progress2 = 1f
                    if (progress3 < 1)
                        progress3 += Random.nextFloat() / 10
                    else
                        progress3 = 1f

                    if(progress1 == 1f && progress2 == 1f && progress3 == 1f)
                        break
                }
            }
        }) {
            Text("Скачать")
        }
    }


}

@Composable
fun BackTime(modifier: Modifier = Modifier) {
    var progress by remember { mutableStateOf(1f) }
    var time by remember { mutableStateOf(60) }
    var color by remember { mutableStateOf(Color.Green) }
    var scope = rememberCoroutineScope()

    Column(
        modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("$time сек.", fontSize = 25.sp)

        CircularProgressIndicator(
            modifier = Modifier.size(50.dp),
            progress = { progress },
            trackColor = Color.Black,
            gapSize = 0.dp,
            strokeCap = StrokeCap.Square,
            color = color
        )

        Button({
            scope.launch {
                while (true) {
                    delay(100)
                    if (time < 30)
                        color = Color.Yellow

                    if (time < 10)
                        color = Color.Red

                    if (progress > 0 && time >= 1) {
                        time--
                        progress -= 0.0165f
                    } else {
                        progress =0f
                        break
                    }
                }
            }
        }) {
            Text("Старт")
        }

        Button({
            progress = 1f
            time = 60
            color = Color.Green
        }) {
            Text("Сброс")
        }
    }
}

@Composable
fun BadgeBoxTask(modifier: Modifier = Modifier) {
    var messageCount by remember { mutableStateOf(0) }
    var showDialog by remember { mutableStateOf(false) }

    Box(modifier.fillMaxSize()) {
        Button(onClick = {
            messageCount += Random.nextInt(5)
        }, modifier = Modifier.align(Alignment.TopCenter)) {
            Text("Обновить")
        }

        if (showDialog) {
            AlertDialog(
                onDismissRequest = { showDialog = false },
                text = { Text("Все сообщения прочитаны") },
                confirmButton = {
                    TextButton(
                        {
                            showDialog = false
                        },
                        colors = ButtonDefaults.buttonColors(containerColor = Color.Green)
                    ) {
                        Icon(Icons.Default.Check, "")
                        Text("Ок")
                    }
                },
            )
        }

        BadgedBox(
            badge = {
                if (messageCount > 0)
                    Badge { Text(text = messageCount.toString()) }
            }, modifier = Modifier
                .align(Alignment.BottomEnd)
        ) {
            FloatingActionButton(
                onClick = {
                    showDialog = true
                    messageCount = 0
                }, modifier = Modifier
                    .padding(5.dp)
            ) {
                Icon(imageVector = Icons.Default.Email, contentDescription = "")
            }
        }
    }
}