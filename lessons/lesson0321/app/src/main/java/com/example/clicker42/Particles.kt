package com.example.clicker42

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.graphics.shadow.ShadowContext
import androidx.compose.ui.text.TextLayoutResult
import androidx.compose.ui.text.drawText
import androidx.compose.ui.text.rememberTextMeasurer
import com.example.clicker42.ui.theme.ctulhuTextStyle
import kotlinx.coroutines.delay
import kotlin.math.PI
import kotlin.math.cos
import kotlin.math.sin
import kotlin.random.Random

data class Particle(
    var x: Float,
    var y: Float,
    val speed: Float = Random.nextFloat() * 5 + 2,
    val angle: Float = Random.nextFloat() * 2 * PI.toFloat(),
    val letter: String = ('A'..'Z').random().toString(),
    var alpha: Float = 1f,
    var lifetime: Float = 1f,
){
    val speedX = cos(angle) * speed
    val speedY = sin(angle) * speed

    fun update(){
        x += speedX
        y += speedY
        alpha -= 0.02f
        lifetime -= 0.02f
    }
}

@Composable
fun ParticleAnimation(particles: SnapshotStateList<Particle>) {
    var invalidate by remember { mutableStateOf(false) }
    LaunchedEffect(Unit) {
        while (true) {
            delay(16L)
            particles.removeAll {
                it.update()
                it.lifetime <= 0
            }
            invalidate = !invalidate
        }
    }

    val textMeasurer = rememberTextMeasurer()

    Canvas(Modifier.fillMaxSize()) {
        invalidate.let {
            for (part in particles) {
                var text = textMeasurer.measure(
                    part.letter,
                    ctulhuTextStyle
                )

                drawText(
                    text,
                    color = Color(
                        0.38f,
                        0.97f,
                        0.86f,
                        part.alpha
                    ),
                    topLeft = Offset(part.x, part.y),
                    shadow = Shadow(
                        color = Color.Black,
                        offset = Offset(5f, 5f),
                        blurRadius = 10f
                    )
                )
            }
        }
    }
}