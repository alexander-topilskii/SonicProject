package com.ato.sonic_ui.animations

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import com.ato.sonic_ui.base.helpers.toPx
import kotlin.random.Random


// Модель данных для частицы конфетти
data class ConfettiParticle(
    val position: Offset,
    val alpha: Float = 1f,
    val velocity: Offset,
    val color: Color,
    val size: Float,
)

// Компонент конфетти, который можно использовать в любом месте
@Composable
fun ConfettiEffect(
    modifier: Modifier = Modifier,
    emitConfetti: Boolean,
    totalDuration: Float = 3f,
    fadingStart: Float = 1f,
    particleCount: Int = 500,
) {
    BoxWithConstraints(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        val xMax = maxWidth.toPx() // Получаем максимальную ширину в пикселях

        // Ваш контент

        val total = totalDuration
        var particles by remember { mutableStateOf<List<ConfettiParticle>>(emptyList()) }
        var confettiTrigger by remember { mutableStateOf(0) }

        val timeLeft = remember { Animatable(total) }


        // Перезапускаем анимацию при изменении confettiTrigger
        LaunchedEffect(confettiTrigger) {
            if (emitConfetti) {
                timeLeft.snapTo(total)
                timeLeft.animateTo(
                    targetValue = 0f,
                    animationSpec = tween(
                        durationMillis = (total * 1000).toInt(),
                        easing = LinearEasing
                    )
                )
            }
        }

        // Обновляем состояние частиц при изменении timeLeft
        LaunchedEffect(timeLeft.value) {
            if (emitConfetti) {
                particles = particles.map { particle ->
                    particle.copy(
                        position = particle.position + particle.velocity,
                        alpha = if (timeLeft.value < fadingStart) timeLeft.value / fadingStart else 1f
                    )
                }
            }
        }

        // Запускаем конфетти при изменении флага emitConfetti
        LaunchedEffect(emitConfetti) {
            if (emitConfetti) {
                particles = generateConfettiParticles(xMax, particleCount)
                confettiTrigger++
            }
        }

        // Рисуем частицы конфетти
        Canvas(modifier = modifier.fillMaxSize()) {
            particles.forEach { particle ->
                drawCircle(
                    color = particle.color.copy(alpha = particle.alpha),
                    radius = particle.size,
                    center = particle.position
                )
            }
        }
    }
}

// Функция для генерации случайных частиц конфетти
fun generateConfettiParticles(xMax: Float, count: Int): List<ConfettiParticle> {
    val random = Random.Default
    return List(count) {
        ConfettiParticle(
            position = Offset(random.nextFloat() * xMax, random.nextFloat() * 100f),
            velocity = Offset(random.nextFloat() * 2f - 1f, random.nextFloat() * 5f),
            color = Color(
                red = random.nextFloat(),
                green = random.nextFloat(),
                blue = random.nextFloat()
            ),
            size = random.nextFloat() * 10f + 5f
        )
    }
}