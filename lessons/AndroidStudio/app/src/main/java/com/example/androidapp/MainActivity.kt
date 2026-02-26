package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.ScrollableState
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyGridScope
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridScope
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Shapes
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.androidapp.ui.theme.AndroidAppTheme
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import java.util.Calendar
import kotlin.random.Random

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //enableEdgeToEdge()
        setContent {
            BoxContainer()
        }
    }
}


@Preview(showBackground = true)
@Composable
fun BoxContainer() {
    Box(Modifier.size(300.dp),
        contentAlignment = Alignment.Center) {
        Text("1", fontSize = 30.sp,
            modifier = Modifier.align(Alignment.TopStart))
        Text("1", fontSize = 30.sp,
            modifier = Modifier.align(Alignment.CenterStart))
        Text("5", fontSize = 30.sp,
            modifier = Modifier.align(Alignment.Center))
        Text("2", fontSize = 30.sp,
            modifier = Modifier.align(Alignment.TopEnd))
        Text("2", fontSize = 30.sp,
            modifier = Modifier.align(Alignment.TopCenter))
        Text("3", fontSize = 30.sp,
            modifier = Modifier.align(Alignment.BottomStart))
        Text("3", fontSize = 30.sp,
            modifier = Modifier.align(Alignment.BottomCenter))
        Text("4", fontSize = 30.sp,
            modifier = Modifier.align(Alignment.BottomEnd))
        Text("4", fontSize = 30.sp,
            modifier = Modifier.align(Alignment.CenterEnd))
    }
}

@Preview(showBackground = true)
@Composable
fun ColumnWeightContainer(){
    Column(Modifier.size(200.dp)) {
        Text("1", fontSize = 30.sp,
            modifier = Modifier.weight(4f).background(Color.Red))
        Text("2", fontSize = 30.sp,
            modifier = Modifier.weight(12f).background(Color.Green))
        Text("3", fontSize = 30.sp,
            modifier = Modifier.weight(3f).background(Color.Blue))
        Text("4", fontSize = 30.sp,
            modifier = Modifier.weight(8f).background(Color.Cyan))

    }
}

@OptIn(ExperimentalFoundationApi::class)
@Preview(showBackground = true)
@Composable
fun LazyColumnContainer() {
    val list = List(50, { it })
    val state = rememberLazyListState()
    val coroutineScope = rememberCoroutineScope()

    LazyColumn(Modifier.fillMaxSize(), state = state) {
        stickyHeader {
            Text(
                "Циферки",
                fontSize = 30.sp,
                modifier = Modifier
                    .background(Color.Magenta)
                    .clickable {
                        coroutineScope.launch {
                            state.animateScrollToItem(23)
                        }
                    })
        }

        itemsIndexed(list) { i, v ->
            Text(
                v.toString(), fontSize = 30.sp,
                color = Color.Red,
                modifier = Modifier.background(
                    if (i % 2 == 0) Color.Cyan
                    else Color.Yellow
                )
            )
        }

    }
}
@Preview(showBackground = true)
@Composable
fun LazyStaggeredGridContainer() {
    LazyVerticalStaggeredGrid(
        StaggeredGridCells.Fixed(5),
        Modifier.fillMaxSize()
    )

    {
        items(150) {
            Box(Modifier
                .width(100.dp)
                .height(
                    Random.nextInt(50,100).dp
                )
                    .size(50.dp)
                    .background(
                        Color(
                            Random.nextInt(140), Random.nextInt(140), Random.nextInt(140)
                        )
                    )
            ) {
                Text(it.toString(), fontSize = 28.sp)
            }
        }
    }
}
@OptIn(ExperimentalLayoutApi::class)
@Preview(showBackground = true)
@Composable
fun FlowColumnContainer() {
    val list = List(50, { it })
    FlowRow(Modifier.fillMaxSize()) {
        list.forEach {
            Text(
                it.toString(),
                fontSize = 30.sp,
                modifier = Modifier
                    .padding(10.dp)
            )
        }
    }
}