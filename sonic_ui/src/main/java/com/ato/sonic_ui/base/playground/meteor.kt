package com.ato.sonic_ui.base.playground

import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.graphics.drawscope.rotate
import androidx.compose.ui.tooling.preview.Preview
import kotlin.random.Random

@Composable
@Preview
fun MeteorAnimation() {
    BoxWithConstraints(modifier = Modifier.fillMaxSize()) {
        val infiniteTransition = rememberInfiniteTransition()

        val xPosition by infiniteTransition.animateFloat(
            initialValue = 0f,
            targetValue = constraints.maxWidth.toFloat(),
            animationSpec = infiniteRepeatable(
                animation = tween(2000, easing = LinearEasing),
                repeatMode = RepeatMode.Restart
            )
        )

        val yPosition by infiniteTransition.animateFloat(
            initialValue = 0f,
            targetValue = constraints.maxHeight.toFloat(),
            animationSpec = infiniteRepeatable(
                animation = tween(2000, easing = LinearEasing),
                repeatMode = RepeatMode.Restart
            )
        )

        val sparkles = remember { List(20) { Sparkle() } }

        Canvas(modifier = Modifier.fillMaxSize()) {
            drawMeteor(Offset(xPosition, yPosition))
            drawSparkles(Offset(xPosition, yPosition), sparkles)
        }
    }
}

fun DrawScope.drawMeteor(position: Offset) {
    rotate(45f) {
        drawCircle(
            color = Color.White,
            radius = 20f,
            center = position
        )
        drawLine(
            color = Color.White,
            start = position,
            end = Offset(position.x - 100f, position.y),
            strokeWidth = 10f
        )
    }
}

fun DrawScope.drawSparkles(meteorPosition: Offset, sparkles: List<Sparkle>) {
    sparkles.forEach { sparkle ->
        drawCircle(
            color = sparkle.color,
            radius = sparkle.size,
            center = Offset(
                meteorPosition.x - sparkle.offsetX,
                meteorPosition.y - sparkle.offsetY
            ),
            alpha = sparkle.alpha
        )
    }
}

class Sparkle {
    var offsetX = Random.nextFloat() * 100f
    var offsetY = Random.nextFloat() * 100f
    var size = Random.nextFloat() * 5f + 1f
    var alpha = Random.nextFloat()
    val color = when (Random.nextInt(3)) {
        0 -> Color.Red
        1 -> Color.Yellow
        else -> Color.Blue
    }
}