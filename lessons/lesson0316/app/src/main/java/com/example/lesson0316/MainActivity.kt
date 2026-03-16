package com.example.lesson0316

import android.net.Uri
import android.os.Bundle
import android.os.Environment
import androidx.activity.ComponentActivity
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collection.mutableVectorOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import com.example.lesson0316.ui.theme.Lesson0316Theme
import java.io.File
import kotlin.contracts.contract

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Lesson0316Theme {
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
    Column(modifier) {
        val context = LocalContext.current
        //Internal
        context.filesDir?.let{Text(it.path)}
        context.getDir("custom", 0)?.let{Text(it.path)}

        //External
        context.getExternalFilesDir("custom")?.let { Text(it.path) }
        context.getExternalFilesDirs("custom").forEach {
            Text(it.path)
        }

        Environment.getExternalStoragePublicDirectory(
             Environment.DIRECTORY_DOWNLOADS
        )?.let{Text(it.path)}

        val file = File(context.filesDir, "example.txt")

        file.writeText("Привет из файла")

        val text = if(file.exists()) file.readText() else ""

        Text(text)

        val eula = context.assets.open("sample.txt")
            .bufferedReader().use{
                it.readText()
            }

        Text(eula)

        var path by remember { mutableStateOf<Uri?>(null) }

        val launcher = rememberLauncherForActivityResult(
            contract = ActivityResultContracts.GetContent()
        ){ uri ->
            path =uri
        }

        Button({launcher.launch("*/*")}) {
            Text("Select")
        }

        Text(path.toString())
    }
}