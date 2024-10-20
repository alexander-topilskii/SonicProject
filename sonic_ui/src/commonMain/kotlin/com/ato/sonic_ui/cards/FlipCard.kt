package com.ato.sonic_ui.cards

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.detectHorizontalDragGestures
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.material3.Card
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.input.pointer.pointerInput


@Composable
fun FlipCard(
    frontContent: @Composable () -> Unit,
    backContent: @Composable () -> Unit,
    modifier: Modifier = Modifier,
    duration: Int = 500,
) {
    var rotated by remember { mutableStateOf(false) }

    val rotation by animateFloatAsState(
        targetValue = if (rotated) 180f else 0f,
        animationSpec = tween(duration)
    )

    val animateFront by animateFloatAsState(
        targetValue = if (!rotated) 1f else 0f,
        animationSpec = tween(duration)
    )

    val animateBack by animateFloatAsState(
        targetValue = if (rotated) 1f else 0f,
        animationSpec = tween(duration)
    )

    // Обрабатываем жесты для свайпа
    val swipeGesture = Modifier.pointerInput(Unit) {
        detectHorizontalDragGestures { change, dragAmount ->
            change.consume()  // Сообщаем системе, что жест был обработан
            if (dragAmount > 0) {  // Свайп вправо
                rotated = false
            } else if (dragAmount < 0) {  // Свайп влево
                rotated = true
            }
        }
    }

    Box(
        modifier = modifier.then(swipeGesture),
        contentAlignment = Alignment.Center
    ) {
        Card(
            modifier = Modifier
                .graphicsLayer { rotationY = rotation }
                .clickable(
                    indication = null,
                    interactionSource = remember { MutableInteractionSource() },
                ) { rotated = !rotated },
        ) {
            if (rotation <= 90f) {
                Box(
                    Modifier.graphicsLayer { alpha = animateFront }
                ) {
                    frontContent()
                }
            } else {
                Box(
                    Modifier
                        .graphicsLayer {
                            alpha = animateBack
                            rotationY = 180f
                        }
                ) {
                    backContent()
                }
            }
        }
    }
}