package com.example.labwork21

import android.os.Bundle
import android.ranging.RangingManager
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Snackbar
import androidx.compose.material3.SnackbarDuration
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.SnackbarResult
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.labwork21.ui.theme.Labwork21Theme
import kotlinx.coroutines.launch
import kotlin.random.Random

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Labwork21Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Box(Modifier.fillMaxSize().padding(innerPadding)) {
//                        Authorization()
 //                       MemoryManage()
                        Game()
                    }
                }
            }
        }
    }
}

@Composable
fun Authorization() {
    var login by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var showDialog by remember { mutableStateOf(false) }

    Column(Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally) {
        OutlinedTextField(login, { login = it })
        OutlinedTextField(password, { password = it })

        Button({ showDialog = true }) { Text("Авторизация") }
    }

    if (showDialog) {
        if (login.isNullOrEmpty()) {
            AlertDialog(
                onDismissRequest = { showDialog = false },
                text = { Text("Поле логина не должно быть пустым") },
                confirmButton = {
                    TextButton(
                        { showDialog = false },
                        colors = ButtonDefaults.buttonColors(containerColor = Color.Green)
                    ) {
                        Icon(Icons.Default.Check, "")
                        Text("Ок")
                    }
                },
                dismissButton = {
                    TextButton(
                        { showDialog = false },
                        colors = ButtonDefaults.buttonColors(containerColor = Color.Red)
                    ) {
                        Icon(Icons.Default.Clear, "")
                        Text("Отмена")
                    }
                },
                containerColor = Color.Yellow,
                textContentColor = Color.Black,
            )
        } else if (password.isNullOrEmpty()) {
            AlertDialog(
                onDismissRequest = { showDialog = false },
                text = { Text("Поле пароля не должно быть пустым") },
                confirmButton = {
                    TextButton(
                        { showDialog = false },
                        colors = ButtonDefaults.buttonColors(containerColor = Color.Green)
                    ) {
                        Icon(Icons.Default.Check, "")
                        Text("Ок")
                    }
                },
                dismissButton = {
                    TextButton(
                        { showDialog = false },
                        colors = ButtonDefaults.buttonColors(containerColor = Color.Red)
                    ) {
                        Icon(Icons.Default.Clear, "")
                        Text("Отмена")
                    }
                },
                containerColor = Color.Yellow,
                textContentColor = Color.Black,
            )
        } else {
            AlertDialog(
                onDismissRequest = { showDialog = false },
                text = { Text("Добро пожаловать, $login") },
                confirmButton = {
                    TextButton(
                        { showDialog = false },
                        colors = ButtonDefaults.buttonColors(containerColor = Color.Green)
                    ) {
                        Icon(Icons.Default.Check, "")
                        Text("Ок")
                    }
                },
                containerColor = Color.Yellow,
                textContentColor = Color.Black,
            )
        }
    }
}

@Composable
fun MemoryManage() {
    val snackbarHostState = remember { SnackbarHostState() }
    val scope = rememberCoroutineScope()
    var cash by remember { mutableStateOf(Random.nextInt(1000)) }
    Scaffold(
        snackbarHost = { SnackbarHost(snackbarHostState) },
    ) { innerPadding ->
        Box(Modifier.padding(innerPadding).fillMaxSize()) {
            Text("$cash МБ", Modifier.align(Alignment.TopCenter), fontSize = 20.sp)
            Button(
                {
                    scope.launch {
                        snackbarHostState.showSnackbar(
                            "Кэш очищен",
                            duration = SnackbarDuration.Short
                        )
                    }
                    cash = 0
                },
                Modifier.align(Alignment.BottomEnd)
            ) {
                Text("Очистить кэш")
            }
        }
    }
}

@Composable
fun Game() {
    val snackbarHostState = remember { SnackbarHostState() }
    val scope = rememberCoroutineScope()
    var isShow by remember { mutableStateOf(false) }
    var isLoad by remember { mutableStateOf(false) }

    Scaffold(
        snackbarHost = { SnackbarHost(snackbarHostState) },
    ) { innerPadding ->
        Box(Modifier.fillMaxSize().padding(innerPadding)) {
            if (isShow) {
                Column(Modifier.align(Alignment.TopCenter), horizontalAlignment = Alignment.CenterHorizontally) {
                    Text("Вы вошли в игру", fontSize = 25.sp)
                    if (isLoad)
                        Image(painterResource(R.drawable.cats),
                            "", Modifier.size(400.dp))
                }
            } else {
                Button({
                    scope.launch {
                        val result = snackbarHostState.showSnackbar(
                            "Загрузить дополнительные ресурсы?",
                            "Ок",
                            true,
                            SnackbarDuration.Indefinite
                        )
                        if (result == SnackbarResult.ActionPerformed) isLoad = true
                        isShow = true
                    }
                }, Modifier.align(Alignment.TopCenter)) {
                    Text("Играть")
                }
            }
        }
    }
}