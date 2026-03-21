package com.example.labwork19

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.pager.PageSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.labwork19.ui.theme.LabWork19Theme
import kotlinx.coroutines.launch

data class Product( var article: String, var name : String,  var price : Float, var imageId : Int )
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LabWork19Theme {
                val products = listOf<Product>(
                    Product("00001", "Яблоко", 130.45f, R.drawable.apple),
                    Product("00002", "Банан", 170.27f, R.drawable.banana),
                    Product("00003", "Хлеб", 52f, R.drawable.bread),
                    Product("00004", "Капуста", 31.28f, R.drawable.cabbage),
                    Product("00005", "Кофе", 1000.54f, R.drawable.coffe),
                    Product("00006", "Печенье", 750.83f, R.drawable.cookies),
                    Product("00007", "Огурец", 300.62f, R.drawable.cucumber),
                    Product("00008", "Яйцо", 800.42f, R.drawable.eggs),
                    Product("00009", "Мука", 90.72f, R.drawable.flour),
                    Product("00010", "Пряники", 250.32f, R.drawable.gingerbread),
                    Product("00011", "Сок", 120.15f, R.drawable.juice),
                    Product("00012", "Мясо", 800.64f, R.drawable.meat),
                    Product("00013", "Молоко", 70.75f, R.drawable.milk),
                    Product("00014", "Масло", 450.86f, R.drawable.oil),
                    Product("00015", "Овсянка", 202.45f, R.drawable.porridge),
                    Product("00016", "Сосиски", 300.19f, R.drawable.sausage),
                    Product("00017", "Креветки", 1500.99f, R.drawable.shrimp),
                    Product("00018", "Чай", 500.56f, R.drawable.tea),
                    Product("00019", "Томаты", 270.84f, R.drawable.tomato),
                    Product("00020", "Вода", 49.49f, R.drawable.water),
                    )
                Scaffold() { innerPadding ->
//                    TaskTwo(modifier = Modifier.padding(innerPadding), products)
//                    TaskThree(modifier = Modifier.padding(innerPadding), products)
//                    ProductVerticalGrid(modifier = Modifier.padding(innerPadding), products)
                    ProductHorizontalGrid(modifier = Modifier.padding(innerPadding), products)
                }
            }
        }
    }
}

@Composable
fun TaskTwo(modifier: Modifier, products: List<Product>) {
    var text by remember { mutableStateOf("Продукт") }
    val listState = rememberLazyListState()
    val showButton = remember { derivedStateOf { listState.firstVisibleItemIndex > 0 } }
    val coroutineScope = rememberCoroutineScope()

    Box(modifier = Modifier.fillMaxSize()) {
        LazyColumn(modifier, state = listState) {
            item { Text(text, fontSize = 30.sp) }
            items(products) { product ->
                Box(Modifier.clickable {
                    text = product.name
                }) { ProductCardOne(product) }
            }
        }
        AnimatedVisibility(
            visible = showButton.value,
            modifier = Modifier.align(Alignment.BottomEnd)
        ) {
            FloatingActionButton(
                onClick = { coroutineScope.launch { listState.scrollToItem(index = 0) } },
                modifier = Modifier.padding(10.dp, 30.dp),
            ) {
                Text("Назад")
            }
        }
    }
}

@Composable
fun TaskThree(modifier: Modifier, products: List<Product>) {
    LazyRow(modifier) {
        items(products) { product ->
            ProductCardTwo(product)
        }
    }
}

@Composable
fun ProductVerticalGrid(modifier: Modifier, products: List<Product>){
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        modifier = modifier,
        horizontalArrangement = Arrangement.Center) {
        items(products) { product ->
            ProductCardTwo(product)
        }
   }
}

@Composable
fun ProductHorizontalGrid(modifier: Modifier, products: List<Product>) {
    LazyHorizontalGrid(
        rows = GridCells.Fixed(3),
        modifier = modifier,
        horizontalArrangement = Arrangement.Center
    ) {
        items(products) { product ->
            ProductCardTwo(product)
        }
    }
}

@Composable
fun ProductCardOne(product: Product) {
    Card(
        elevation = CardDefaults.cardElevation(
            defaultElevation = 6.dp
        ),
        colors = CardDefaults.cardColors(containerColor = Color(139, 245, 78)),
        modifier = Modifier.fillMaxWidth().padding(10.dp),
        border = BorderStroke(1.dp, Color.Magenta)
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Image(
                painterResource(product.imageId),
                product.name,
                Modifier.size(80.dp)
            )
            Column(
                modifier = Modifier.padding(5.dp)
            ) {
                Text(
                    text = product.name,
                    fontSize = 25.sp,
                    color = Color.DarkGray
                )
                Text(
                    text = "${product.price}",
                    fontSize = 20.sp,
                    color = Color.DarkGray
                )
            }
        }
    }
}

@Composable
fun ProductCardTwo(product: Product) {
    Card(modifier = Modifier.padding(10.dp)) {
        Image(painterResource(product.imageId), "",
            Modifier.size(150.dp).clip(
                RoundedCornerShape(75.dp))
                .align(Alignment.CenterHorizontally))
        Column(
            modifier = Modifier.padding(5.dp).align(Alignment.CenterHorizontally)
        ) {
            Text(
                text = product.name,
                fontSize = 25.sp,
                color = Color.DarkGray,
                modifier = Modifier.align(Alignment.CenterHorizontally),
            )
            Text(
                text = "${product.price}",
                fontSize = 20.sp,
                color = Color.DarkGray,
                modifier = Modifier.align(Alignment.CenterHorizontally),
            )
        }
    }
}