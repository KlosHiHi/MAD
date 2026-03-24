package com.example.clicker42

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.awaitFirstDown
import androidx.compose.foundation.gestures.waitForUpOrCancellation
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateMapOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.layout.positionInParent
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.compose.LocalLifecycleOwner
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.clicker42.ui.theme.Clicker42Theme
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlin.random.Random

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ClickerGame()
        }
    }
}

data class PageData(val name: String, val icon: ImageVector)

@Composable
fun ClickerGame(vm: GameViewModel = viewModel()) {
    val pagerState = rememberPagerState { 2 }
    val scrollScope = rememberCoroutineScope()
    val pages = remember {
        mutableStateMapOf(
            0 to PageData("Main", Icons.Default.Home),
            1 to PageData("Shop", Icons.Default.ShoppingCart),
            3 to PageData("Settings", Icons.Default.Settings),
        )
    }

    LaunchedEffect(Unit) {
        while (true){
            delay(1000)
            vm.onAutoClick()
        }
    }

    Clicker42Theme {
        Scaffold(
            modifier = Modifier.fillMaxSize(),
            topBar = {
                Column(
                    Modifier
                        .statusBarsPadding()
                        .fillMaxWidth()
                        .height(100.dp)
                        .background(MaterialTheme.colorScheme.primary),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        "Нажатий на урода: ",
                        textAlign = TextAlign.Center,
                        fontSize = 30.sp,
                        color = MaterialTheme.colorScheme.onPrimary
                    )
                    Text(
                        "%.2f".format(vm.score),
                        textAlign = TextAlign.Center,
                        fontSize = 30.sp,
                        color = MaterialTheme.colorScheme.onPrimary
                    )
                }
            },
            bottomBar = {
                Row(
                    Modifier
                        .statusBarsPadding()
                        .fillMaxWidth()
                        .height(100.dp)
                        .background(MaterialTheme.colorScheme.primaryContainer),
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    pages.forEach { (n, page) ->
                        Button(
                            { scrollScope.launch { pagerState.animateScrollToPage(n,
                                animationSpec = tween(400)) } },
                            Modifier.weight(1f)
                                .fillMaxHeight(),
                            shape = RectangleShape,
                            border = BorderStroke(3.dp, MaterialTheme.colorScheme.primary),
                            colors = ButtonDefaults.buttonColors(
                                containerColor =
                                    if (pagerState.currentPage == n)
                                        MaterialTheme.colorScheme.primary
                                    else
                                        MaterialTheme.colorScheme.secondary
                            )
                        ) {
                            Icon(
                                page.icon,
                                page.name
                            )
                        }
                    }
                }
            }
        ) { innerPadding ->
            HorizontalPager(
                pagerState,
                Modifier.padding(innerPadding)
            ) { page ->
                when (page) {
                    0 -> GameScreen(vm)
                    1 -> ShopScreen(vm)
                }
            }
        }
    }
}

@Composable
fun ShopScreen(vm: GameViewModel) {
    Column(Modifier.fillMaxSize()) {
        vm.upgrades.forEach { (type, upgrade) ->
            Card(Modifier.fillMaxWidth().padding(10.dp).clickable{vm.onUpgrade(upgrade)}) {
                Text(
                    type.title, fontSize = 25.sp,
                    modifier = Modifier.padding(5.dp)
                )
                Text(
                    "${upgrade.level} ур. Значение: %.2f".format(upgrade.currentValue()),
                    modifier = Modifier.padding(5.dp)
                )
                Text(
                    "Стоимость: %.2f".format(upgrade.currentCost()),
                    modifier = Modifier.padding(5.dp)
                )
            }
        }
    }
}

@Composable
fun GameScreen(vm: GameViewModel) {
    Box(Modifier.fillMaxSize()) {
        val particles = remember { mutableStateListOf<Particle>() }
        var buttonPosition by remember { mutableStateOf(Offset.Zero) }

        var isPressed by remember { mutableStateOf(false) }
        val scale by animateFloatAsState(
            if (isPressed) 0.95f else 1f,
            animationSpec = tween(100)
        )


        Box(
            Modifier.size(300.dp)
                .clip(CircleShape)
                .align(Alignment.Center)
                .onGloballyPositioned{
                    buttonPosition = it.positionInParent()
                }
                .pointerInput(Unit) {
                    coroutineScope {
                        while (true) {
                            awaitPointerEventScope {
                                val down = awaitFirstDown()
                                val position = down.position + buttonPosition
                                isPressed = true
                                vm.onTap()
                                repeat(5) {
                                    particles.add(
                                        Particle(position.x, position.y)
                                    )
                                }
                                down.consume()
                                val up = waitForUpOrCancellation()
                                if (up != null)
                                    isPressed = false
                            }
                        }
                    }
                }
        ) {
            Image(
                painterResource(R.drawable.cthulhu_star),
                "Background", modifier = Modifier.fillMaxSize()
            )
            Image(
                painterResource(R.drawable.cthulhu),
                "Cthulhu",
                modifier = Modifier
                    .graphicsLayer(scaleX = scale, scaleY = scale)
                    .fillMaxSize(0.8f)
                    .align(Alignment.Center)
            )
        }
        ParticleAnimation(particles)
    }
}

@Composable
fun ApplicationLifetimeObserver(onExit:()->Unit) {
    val lifecicleOwner = LocalLifecycleOwner.current

    DisposableEffect(lifecicleOwner) {
        val observer = object : DefaultLifecycleObserver{
            override fun onStop(owner: LifecycleOwner) {
                super.onStop(owner)
            }

            override fun onDestroy(owner: LifecycleOwner) {
                super.onDestroy(owner)
            }

            override fun onPause(owner: LifecycleOwner) {
                super.onPause(owner)
            }
        }
    }
}