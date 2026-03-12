package com.example.lesson0312

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Build
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.FabPosition
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarDuration
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.SnackbarResult
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.lesson0312.ui.theme.AppTheme
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            var isDarkTheme by remember { mutableStateOf(false) }

            AppTheme(darkTheme = isDarkTheme) {
                val snackbarHostState = remember { SnackbarHostState() }
                val scope = rememberCoroutineScope()

                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    topBar = {
                        TopAppBar(
                            title = { Text("Крутая программа") },
                            navigationIcon = {
                                IconButton({}) {
                                    Icon(
                                        Icons.Filled.Menu,
                                        ""
                                    )
                                }
                            },
                            actions = {
                                IconButton({isDarkTheme = !isDarkTheme}) {
                                    Icon(
                                        Icons.Filled.Settings,
                                        ""
                                    )
                                }
                            }
                        )
                    },
                    bottomBar = {
//                        BottomAppBar(
//                            actions = {
//                                IconButton({}) {
//                                    Icon(
//                                        Icons.Filled.Favorite,
//                                        "")
//                                }
//                                IconButton({}) {
//                                    Icon(
//                                        Icons.Filled.Favorite,
//                                        "")
//                                }
//                                IconButton({}) {
//                                    Icon(
//                                        Icons.Filled.Favorite,
//                                        "")
//                                }
//                            }
//                        )
                        NavigationBar {
                            NavigationBarItem(
                                selected = true,
                                onClick = {},
                                icon = {
                                    Icon(
                                        Icons.Filled.Favorite,
                                        ""
                                    )
                                }
                            )
                            NavigationBarItem(
                                selected = false,
                                onClick = {},
                                icon = {
                                    Icon(
                                        Icons.Filled.Build,
                                        ""
                                    )
                                }
                            )
                            NavigationBarItem(
                                selected = false,
                                onClick = {},
                                icon = {
                                    Icon(
                                        Icons.Filled.Phone,
                                        ""
                                    )
                                }
                            )
                        }
                    },
                    floatingActionButton = {
//                        FloatingActionButton({}) {
//                            Icon(Icons.Filled.Edit, "")
//                        }
                        ExtendedFloatingActionButton(
                            text = { Text("Добавить") },
                            icon = { Icon(Icons.Filled.Edit, "") },
                            onClick = {
                                scope.launch {
                                    var result = snackbarHostState.showSnackbar(
                                        message = "Привет",
                                        actionLabel = "Ок",
                                        withDismissAction = true,
                                        duration = SnackbarDuration.Short
                                    )

                                    when (result){
                                        SnackbarResult.Dismissed -> {}
                                        SnackbarResult.ActionPerformed -> {}
                                    }
                                }
                            }
                        )
                    },
                    floatingActionButtonPosition = FabPosition.Start,

                    snackbarHost = {
                        SnackbarHost(snackbarHostState)
                    }

                ) { innerPadding ->
                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Column(modifier = modifier) {
        Button({}) {
            Text(
                text = "Hello $name!"
            )
        }

        Card(modifier = Modifier.size(400.dp, 200.dp),
            shape = MaterialTheme.shapes.extraSmall,
            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.tertiaryContainer,
                contentColor = MaterialTheme.colorScheme.onTertiaryContainer
        )) {
            Text(
                "Ты хотел этой сцены, ведь ты сам её устроил",
                Modifier.padding(10.dp), style = MaterialTheme.typography.headlineLarge
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    AppTheme {
        Greeting("Android")
    }
}