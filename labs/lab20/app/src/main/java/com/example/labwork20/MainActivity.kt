package com.example.labwork20

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.materialIcon
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.labwork20.screens.Auth
import com.example.labwork20.screens.Product
import com.example.labwork20.screens.ProductInfo
import com.example.labwork20.screens.ProductList
import com.example.labwork20.screens.Register
import com.example.labwork20.ui.theme.Labwork20Theme

enum class Screen {
    AUTH,
    REG,
    HOME,
    DETAIL
}

var products = listOf<Product>(
    Product("Брелок акриловый", 10.0f),
    Product("Набор обложек", 15.0f),
    Product("Модель анатомическая", 65.4f),
    Product("Значок", 67.4f),
    Product("Фотоальбом", 10.3f),
    Product("Помидоры 1кг.", 78.5f),
    Product("Книга", 16.4f),
    Product("Бургер", 30.5f),
    Product("Кружка Хеллоу-Китти", 19.8f),
    Product("Набор наклеек", 20.5f),
)

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Labwork20Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                        MainScreen(Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun MainScreen(modifier: Modifier = Modifier) {
    Box(modifier) {
        val navController = rememberNavController()
        var product by remember { mutableStateOf(Product("", 0f)) }

        NavHost(navController = navController, startDestination = Screen.AUTH.name) {
            composable(Screen.AUTH.name) {
                Auth(
                    reg = {
                        navController.navigate(Screen.REG.name)
                    },
                    list = {
                        navController.navigate(Screen.HOME.name)
                    })
            }
            composable(Screen.REG.name) {
                Register(auth = {
                    navController.navigate(Screen.AUTH.name) {
                        popUpTo(Screen.REG.name) {
                            inclusive = true
                        }
                    }
                })
            }
            composable(Screen.HOME.name) { ProductList(products,
                {navController.navigate(Screen.DETAIL.name)}) }
            composable(Screen.DETAIL.name) { ProductInfo(product) }
        }
        FloatingActionButton({ navController.popBackStack() }, Modifier.align(Alignment.TopStart))
        {
            Icon(Icons.Filled.ArrowBack, "")
        }
    }
}