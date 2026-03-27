package com.example.lab23

import android.accounts.Account
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.lab23.screens.AccountMoney
import com.example.lab23.screens.Deposit
import com.example.lab23.screens.Transit
import com.example.lab23.ui.theme.Lab23Theme

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Lab23Theme {

                Scaffold(modifier = Modifier.fillMaxSize(), topBar = {
                    TopAppBar(
                        { Text("") },
                        navigationIcon = {
                            IconButton({})
                            { Icon(Icons.Filled.Menu, contentDescription = "Меню") }
                        },
                        modifier = Modifier
                    )
                }) { innerPadding ->
                    Greeting(modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

sealed class Routes(val route: String) {

    object Account : Routes("account")
    object Deposit : Routes("deposit")
    object Transit : Routes("transit")
}

@Composable
fun Greeting(modifier: Modifier = Modifier) {
    val navController = rememberNavController()
    Box(modifier.fillMaxSize()) {
        NavHost(
            navController = navController,
            startDestination = Routes.Account.route
        ) {

            composable(Routes.Account.route) {
                AccountMoney(
                    deposit = {
                        navController.navigate(Routes.Deposit.route)
                    },
                    transit = {
                        navController.navigate(Routes.Transit.route)
                    })
            }
            composable(Routes.Deposit.route) {
                Deposit(
                    account = {
                        navController.navigate(Routes.Account.route)
                    }
                )
            }
            composable(Routes.Transit.route) {
                Transit(
                    account = {
                        navController.navigate(Routes.Account.route)
                    })
            }
        }
    }
}
