package com.example.lesson0325

import android.os.Bundle
import android.widget.Button
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.ProgressIndicatorDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.lesson0325.ui.theme.Lesson0325Theme
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Lesson0325Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting(modifier: Modifier = Modifier) {
    var progress by remember { mutableStateOf(0.0f) }
    var scope = rememberCoroutineScope()
//    LaunchedEffect(Unit) {
//        while (progress < 1f) {
//            delay(300)
//            progress += 0.01f
//        }
//    }

    Column(modifier) {
        CircularProgressIndicator(
            progress = { progress },
            modifier = Modifier.size(100.dp),
            color = Color.Red,
            strokeWidth = 10.dp,
            trackColor = Color.Magenta,
            strokeCap = StrokeCap.Square,
            gapSize = 0.dp
        )

        LinearProgressIndicator(
            progress = { progress },
            modifier = Modifier.size(100.dp),
            color = Color.Red,
            trackColor = Color.Magenta,
            strokeCap = StrokeCap.Square,
            gapSize = 0.dp
        )
        Button({
//            progress += 0.1f
            scope.launch {
                while (progress < 1f) {
                    delay(300)
                    progress += 0.01f
                }
            }
        }) {
            Text("Далее")
        }

        var messages by remember {   mutableStateOf(0)}


        BadgedBox({
                Badge {
                    Text(messages.toString())
                }
        }) {
            FloatingActionButton({}) {
                Icon(Icons.Default.Email, "")
            }
        }
    }
}