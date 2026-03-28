package com.example.labwork15

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.labwork15.screens.Authorization
import com.example.labwork15.screens.Registration
import com.example.labwork15.screens.Screens
import com.example.labwork15.screens.UserProfile
import com.example.labwork15.ui.theme.Labwork15Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Labwork15Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    var currentScreen by remember { mutableStateOf(Screens.AUTH_SCREEN) }
                    Box(Modifier.fillMaxSize().padding(innerPadding)) {
                        when (currentScreen) {
                            Screens.AUTH_SCREEN -> Authorization({
                                currentScreen = Screens.REG_SCREEN
                            }, {
                                currentScreen = Screens.USER_PROFILE_SCREEN
                            })

                            Screens.REG_SCREEN -> Registration({ screen ->
                                currentScreen = screen
                            })

                            Screens.USER_PROFILE_SCREEN -> UserProfile({ screen ->
                                currentScreen = screen
                            })
                        }
                    }
                }
            }
        }
    }
}

