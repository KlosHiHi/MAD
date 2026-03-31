package com.example.labwork24

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.Animatable
import androidx.compose.animation.animateColor
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.VectorConverter
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.animateSize
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.keyframes
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.repeatable
import androidx.compose.animation.core.spring
import androidx.compose.animation.core.tween
import androidx.compose.animation.core.updateTransition
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material3.Button
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.graphics.vector.VectorProperty
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.labwork24.ui.theme.Labwork24Theme
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Labwork24Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Column(modifier = Modifier.fillMaxSize().padding(innerPadding)) {
//                    FirstAnimation(modifier = Modifier.padding(innerPadding))
//                        SecondAnimation();
                        ThirdAnimation();
//                        FourAnimation()
                    }
                }
            }
        }
    }
}

@Composable
fun FirstAnimation (modifier: Modifier = Modifier) {
    var isMagenta by remember { mutableStateOf(false) }
    val color by animateColorAsState(
        if (isMagenta) Color.Magenta else Color.Green,
        tween(3000)
    )

    var colored by remember { mutableStateOf(false) }
    val color1 by animateColorAsState(
        if (colored) Color.Yellow else Color.Cyan,
        animationSpec = keyframes {
            durationMillis = 10000
            if (colored) {
                Color.Cyan at 1000
                Color.Yellow at 2000
                Color.Cyan at 3000
                Color.Yellow at 4000
                Color.Cyan at 5000
                Color.Yellow at 6000
                Color.Cyan at 7000
                Color.Yellow at 8000
                Color.Cyan at 9000
            }
        }
    )

    var scaled by remember { mutableStateOf(false) }
    val scale by animateDpAsState(
        if (scaled) 450.dp else 100.dp,
        animationSpec = repeatable(3, tween(1000), repeatMode = RepeatMode.Reverse)
    )

    var springed by remember { mutableStateOf(false) }
    val spring by animateDpAsState(
        if (scaled) 250.dp else 100.dp,
        animationSpec = spring(dampingRatio = Spring.DampingRatioLowBouncy)
    )


    val colors by animateColorAsState(
        if (isMagenta) Color.Magenta else Color.Green,
        animationSpec = infiniteRepeatable(
            animation = tween(1000), repeatMode = RepeatMode.Reverse
        )
    )

    Box(modifier.fillMaxSize()) {
        Box(modifier.size(100.dp).background(color).align(Alignment.TopStart)) {}

        Box(modifier.size(100.dp).background(color1).align(Alignment.TopEnd)) {}

        Image(
            painter = painterResource(R.drawable.ppp),
            "",
            modifier = Modifier.size(scale).align(Alignment.BottomStart)
        )

        Image(
            painter = painterResource(R.drawable.ppp),
            "",
            modifier = Modifier.size(spring).align(Alignment.BottomEnd)
        )

        Box(modifier.size(100.dp).background(colors).align(Alignment.Center)) {}

        Button({
            isMagenta = !isMagenta
            colored = !colored
            scaled = !scaled
            springed = !springed

        }, modifier = Modifier.align(Alignment.BottomCenter)) { }
    }
}

@Composable
fun SecondAnimation() {
    var coroutineScope = rememberCoroutineScope()
    val animateColor = remember { Animatable(Color.Red) }
    val animateSize = remember {
        Animatable(
            Size(100f, 100f),
            Size.VectorConverter
        )
    }
    val animateRotation = remember {
        Animatable(0f)
    }

    Box(modifier = Modifier.fillMaxSize()) {
        Box(
            modifier = Modifier.size(150.dp).background(animateColor.value)
                .align(Alignment.TopCenter)
        ) {}

        Image(
            painter = painterResource(R.drawable.ppp),
            "",
            modifier = Modifier.size(
                animateSize.value.width.dp,
                animateSize.value.height.dp
            ).clip(CircleShape).align(Alignment.BottomCenter)
        )

        Image(painter = painterResource(R.drawable.troll),"",
            modifier = Modifier.rotate(animateRotation.value).size(200.dp).align(Alignment.Center))


        Button({
            coroutineScope.launch {
                animateColor.animateTo(Color.Green, animationSpec = tween(1000))
            }
            coroutineScope.launch {
                animateRotation.animateTo(360f, tween(2000))
            }
            coroutineScope.launch {
                animateSize.animateTo(
                    Size(200f, 200f),
                    animationSpec = repeatable(
                        3,
                        tween(1000),
                        RepeatMode.Restart
                    )
                )
            }
        }, Modifier.align(Alignment.CenterStart)) { Text("Нажми") }
    }
}

@Composable
fun ThirdAnimation() {
    var isRefact by remember { mutableStateOf(true) }
    var coroutineScope = rememberCoroutineScope()

    var transition = updateTransition(isRefact)
    val animateSize by transition.animateSize { state ->
        if (state) Size(100f, 200f) else Size(300f, 600f)
    }
    val animateRotation by transition.animateFloat { state ->
        if (state) 0f else 360f
    }

    Box(modifier = Modifier.fillMaxSize()) {

        Image(
            painter = painterResource(R.drawable.junk), "", modifier = Modifier.size(
                animateSize.width.dp, animateSize.height.dp
            ).rotate(animateRotation).align(Alignment.Center).clickable {
                isRefact = !isRefact
            }
        )
    }
}

@Composable
fun FourAnimation() {
    val transition = rememberInfiniteTransition()

    val scale by transition.animateFloat(
        initialValue = 1f, targetValue = 5f,
        animationSpec = infiniteRepeatable(
            animation = tween(1000),
            repeatMode = RepeatMode.Reverse
        )
    )
    Box(
        Modifier.fillMaxSize()
    ) {
        FloatingActionButton(
            {},
            modifier = Modifier
                .align(Alignment.Center)
                .graphicsLayer(scaleX = scale, scaleY = scale),
        ) {
            Icon(
                imageVector = Icons.Filled.Phone, contentDescription = "",

                tint = Color.Magenta
            )
        }
    }
}

@Composable
fun FiveAnimation(){

}