package com.example.lesson0406

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import coil3.compose.AsyncImage
import com.example.lesson0406.data.MarsRepository
import com.example.lesson0406.ui.theme.Lesson0406Theme
import com.example.lesson0406.MainViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        val repository = MarsRepository()
        setContent {

        }
    }
}

@Composable
fun MainScreen(vm: MainViewModel = viewModel()) {
    Lesson0406Theme {
        Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
            LazyColumn(Modifier.fillMaxSize().padding(innerPadding)) {
                items(vm.list) {
                    AsyncImage(it.imgSrc, null)
                }
            }
        }
    }
}