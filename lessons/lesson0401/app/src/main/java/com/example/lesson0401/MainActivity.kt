package com.example.lesson0401

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.lesson0401.ui.theme.Lesson0401Theme

private val Int.id: Any

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Main()
        }
    }
}

@Composable
fun Main(vm: PlayerViewModel = viewModel()) {
    val players by vm.playerList.observeAsState(listOf())
    Lesson0401Theme {
        Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
            Column(Modifier.fillMaxSize().padding(innerPadding)) {
                OutlinedTextField(vm.playerName,
                    {vm.changeName(it)},
                    label = {Text("Name")})
                OutlinedTextField(vm.playerLevel.toString(),
                    {vm.changeLevel(it)},
                    label = {Text("Name")})
                Button({vm.addPlayer()}) {
                    Text("Добавить")
                }

                LazyColumn(Modifier.fillMaxSize()) {
                    items(items = players){ p ->
                        Row(Modifier.fillMaxSize().padding(8.dp)){
                            Text(p.id.toString(), Modifier.weight(1f))
                            Text(p.name.toString(), Modifier.weight(1f))
                            Text(p.level.toString(), Modifier.weight(1f))
                        }
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview(){
    Main()
}