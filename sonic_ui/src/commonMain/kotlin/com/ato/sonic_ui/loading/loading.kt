package com.ato.sonic_ui.loading

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import org.jetbrains.compose.ui.tooling.preview.Preview

@Preview
@Composable
fun Loading(modifier: Modifier = Modifier) {
    val animatedProgress = remember { Animatable(0f) }

    LaunchedEffect(Unit) {
        animatedProgress.animateTo(
            targetValue = 2f,
            animationSpec = infiniteRepeatable(
                animation = tween(durationMillis = 1500, easing = LinearEasing),
            ),
        )
    }


    Canvas(modifier = modifier.fillMaxSize()) {
        val x: Float = this.center.x * animatedProgress.value
        val offset = Offset(x, this.center.y)
        drawCircle(
            Color.Black,
            radius = 20f,
            center = offset
        )
    }
}

