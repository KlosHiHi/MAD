package com.example.lab23.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.example.lab23.Routes

@Composable
fun Deposit(modifier: Modifier = Modifier, account:() -> Unit) {
    val navController = rememberNavController()
    Column(modifier) {
        Button(onClick = {
            navController.navigate(Routes.Deposit.route) {
                popUpTo(Routes.Account.route)
            }
        }) {
            Text(text = "To Account Page")
        }
    }
}
