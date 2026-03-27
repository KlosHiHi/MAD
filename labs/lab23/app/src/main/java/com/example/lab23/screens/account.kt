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
fun AccountMoney(modifier: Modifier = Modifier, deposit:() -> Unit, transit:() -> Unit) {

    var money = 34.5f
    val navController = rememberNavController()
    Column(modifier) {
        Icon(Icons.Default.Person, "")
        Text("${money}$")
        Button(onClick = {
            navController.navigate(Routes.Deposit.route)
        }) {
            Text(text = "Deposit")
        }
    }
    Text(text = "To Deposit Page")

    Button(onClick = {
        navController.navigate(Routes.Transit.route)
    }) {
        Text(text = "Transit")
    }
}