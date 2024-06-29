package com.ato.sonic_ui.base.playground

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import org.jetbrains.compose.ui.tooling.preview.Preview
import kotlin.random.Random

@Composable
fun FireEffect(
    modifier: Modifier = Modifier,
    numParticles: Int = 100,
    maxRadius: Dp = 20.dp
) {
    Canvas(modifier = modifier.fillMaxSize()) {
            repeat(numParticles) {
                val x = Random.nextInt(size.width.toInt()).toFloat()
                val y = Random.nextInt(size.height.toInt()).toFloat()
                val radius = Random.nextDouble(0.1, 1.0) * maxRadius.toPx()
                val alpha = Random.nextDouble(0.5, 1.0)
                val color = Color(
                    red = 1f,
                    green = Random.nextFloat(),
                    blue = 0f,
                    alpha = alpha.toFloat()
                )
                drawCircle(
                    color = Color.Red,
                    center = Offset(x, y),
                    radius = radius.toFloat(),
                )
        }
    }
}

@Composable
@Preview
fun FireScreen() {
    Surface(modifier = Modifier.fillMaxSize()) {
        FireEffect(modifier = Modifier.wrapContentSize())
    }
}