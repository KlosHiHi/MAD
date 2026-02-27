package com.example.a2702

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.a2702.ui.theme._2702Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val state = remember { mutableStateOf("Hello world")}
            var state1 by rememberSaveable { mutableStateOf("Hello world")}
            _2702Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Column(modifier = Modifier.padding(innerPadding)) {
                        TextField(state.value, { state.value = it})
                        TextField(state1, { state1 = it})
                        Counter()
                    }
                }
            }
        }
    }
}

@Composable
fun Counter() {
    var clicks by remember { mutableStateOf(0) }
    val onClicksChange = {value:Int -> clicks = value}

    Column(){
        Text(text = clicks.toString())
        Increment(clicks, onClicksChange)
    }
}

@Composable
fun Increment(clicks: Int, onClickChange: (Int) -> Unit )
{
    Button({
        onClickChange(clicks+1)
    }) {
        Text("+")
    }
}

@Composable
fun LoginScreen() {
    var login by remember {mutableStateOf("")}
    var password by remember {mutableStateOf("")}
    var showMessage by remember { mutableStateOf(false) }

    if(showMessage){
        AlertDialog({showMessage = false},
            confirmButton = {
                Button({showMessage = false}) {
                    Text("Ок")
                }
            },
            text = {Text("$login авторизован")})
    }

    Column {
        OutlinedTextField(
            login,
            {login=it},
            label={Text("Логин")})

        OutlinedTextField(
            password,
            {password=it},
            label = {Text("Пароль")})

        Button({}) {
            Text("Войти")
        }
    }
}

/**
 * @param T обобщённый тип
 * @sample com.example.states.sumExample
 */
@Composable
fun <T> sum(a:T, b:T) : T{
    return a
}