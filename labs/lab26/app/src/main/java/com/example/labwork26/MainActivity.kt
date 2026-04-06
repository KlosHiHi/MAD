package com.example.labwork26

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import com.example.labwork26.ui.theme.Labwork26Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Labwork26Theme {
                val viewModel: UserViewModel = viewModel()
                UserListScreen(viewModel = viewModel)
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Composable
fun UserListScreen(viewModel: UserViewModel) {
    val users = viewModel.users

    LazyColumn {
        items(viewModel.users) { user ->
            Text(text = user.login, modifier = Modifier.padding(16.dp))
        }
    }
}

fun assUser(login: String, password: String, email: String){
    if (login.isNotBlank() && password.isNotBlank() && email.isNotBlank()){
        _users.add(User(login,password,email))
    }
}

data class User(
    val login: String,
    val password: String,
    val email: String
)

class UserViewModel: ViewModel(){
    private val _users = mutableStateOf<User>()
    val users: List<User> = _users

    init {
        _users.addAll(listOf(
            User("Jotaro Kujo", "Useless", "sametype@stand.jp"),
            User("Jolyne Kujo", "Woman", "itsjustamistake@jail.us"),
            User("Enrico Pucci", "SpiralStaircase", "whiteS@heaven.us")
        ))
    }
}