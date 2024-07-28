package com.ato.splash.ui

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.platform.testTag
import com.ato.splash.component.SplashComponent
import kotlin.math.min
import kotlin.random.Random


@Composable
fun SplashContent(
    component: SplashComponent? = null,
    modifier: Modifier = Modifier
) {
//    val model by component.uiState.collectAsState(null)

    AnimatedSplash()
}



@Composable
internal fun AnimatedSplash() {
    val density = LocalDensity.current

    Scaffold(modifier = Modifier.testTag("testTagLoading")) {
        BoxWithConstraints(
            Modifier
                .fillMaxSize()
                .padding(it)
        ) {
            with(density) {
                val maxWidth = maxWidth
                val maxHeight = maxHeight

                for (i in 0..50) {
                    val centerX = remember {
                        Animatable(Random.nextInt(0, maxWidth.toPx().toInt()).toFloat())
                    }
                    val centerY = remember {
                        Animatable(Random.nextInt(0, maxHeight.toPx().toInt()).toFloat())
                    }

                    LaunchedEffect(Unit) {
                        while (true) {
                            centerY.animateTo(
                                targetValue = Random.nextInt(0, maxHeight.toPx().toInt()).toFloat(),
                                animationSpec = tween(
                                    durationMillis = Random.nextInt(2000, 5000),
                                    easing = LinearEasing
                                )
                            )
                            centerX.animateTo(
                                targetValue = Random.nextInt(0, maxWidth.toPx().toInt()).toFloat(),
                                animationSpec = tween(
                                    durationMillis = Random.nextInt(2000, 5000),
                                    easing = LinearEasing
                                )
                            )
                        }
                    }

                    val radius = remember {
                        Random.nextInt(16, min(maxWidth.toPx(), maxHeight.toPx()).toInt() / 14)
                            .toFloat()
                    }
                    val alpha = remember { (Random.nextInt(10, 85) / 100f) }
                    val color = MaterialTheme.colorScheme.primary

                    Canvas(modifier = Modifier.fillMaxSize()) {
                        drawCircle(
                            color = color,
                            center = Offset(
                                x = centerX.value,
                                y = centerY.value
                            ),
                            radius = radius * 0.75f,
                            alpha = alpha
                        )
                    }
                }
            }
        }
    }
}
