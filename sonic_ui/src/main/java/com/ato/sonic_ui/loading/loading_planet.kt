package com.ato.sonic_ui.loading

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.TileMode
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import kotlin.math.acos
import kotlin.math.cos
import kotlin.math.sin

private const val NUM_DOTS = 1000
private const val GLOBE_RADIUS_FACTOR = 0.7f
private const val DOT_RADIUS_FACTOR = 0.007f
private const val FIELD_OF_VIEW_FACTOR = 0.8f
private const val TWO_PI = 2 * Math.PI.toFloat()
private const val ORBIT_RADIUS_FACTOR = 0.3f

@Composable
fun LoadingAtoms(colors: List<Color>, modifier: Modifier = Modifier) {
    val animatedProgress = remember { Animatable(0f) }
    val brush = getBrush(colors, 80.dp)

    LaunchedEffect(Unit) {
        animatedProgress.animateTo(
            targetValue = 1f,
            animationSpec = infiniteRepeatable(
                animation = tween(durationMillis = 20000, easing = LinearEasing),
                repeatMode = RepeatMode.Reverse,
            ),
        )
    }

    val dotInfos = remember {
        (0 until NUM_DOTS).map {
            val azimuthAngle = Math.random().toFloat() * TWO_PI
            val polarAngle = Math.random().toFloat() * TWO_PI
            DotInfo(azimuthAngle, polarAngle)
        }
    }

    Canvas(modifier = modifier) {
        // Compute the animated position of dots in spherical motion.
        val rotationY = animatedProgress.value * TWO_PI
        val rotationX = animatedProgress.value * TWO_PI / 2 // to vary the rotation

        dotInfos.forEach {
            val minSize = size.minDimension
            val orbitRadius = minSize * ORBIT_RADIUS_FACTOR

            // Calculate the dot's coordinates in 3D space, with oscillating distance.
            val distance = orbitRadius * (1 + 0.5f * sin(rotationY + it.polarAngle))
            val x = distance * sin(it.azimuthAngle) * cos(it.polarAngle)
            val y = distance * sin(it.azimuthAngle) * sin(it.polarAngle)
            val z = distance * cos(it.azimuthAngle)

            // Rotate the dot's 3D coordinates about the y-axis and x-axis.
            val rotatedX = cos(rotationY) * x - sin(rotationY) * z
            val rotatedZ = sin(rotationY) * x + cos(rotationY) * z
            val finalX = rotatedX
            val finalY = cos(rotationX) * y - sin(rotationX) * rotatedZ
            val finalZ = sin(rotationX) * y + cos(rotationX) * rotatedZ

            // Project the rotated 3D coordinates onto the 2D plane.
            val fieldOfView = minSize * FIELD_OF_VIEW_FACTOR
            val projectedScale = fieldOfView / (fieldOfView - finalZ)
            val projectedX = (finalX * projectedScale) + minSize / 2f
            val projectedY = (finalY * projectedScale) + minSize / 2f

            // Scale the dot such that dots further away from the camera appear smaller.
            val dotRadius = minSize * DOT_RADIUS_FACTOR
            val scaledDotRadius = dotRadius * projectedScale

            val offset = Offset(projectedX, projectedY)
            if (offset != Offset.Unspecified) {
                drawCircle(
                    brush = brush,
                    radius = scaledDotRadius,
                    center = offset,
                )
            }
        }
    }
}

@Composable
fun LoadingPlanet(colors: List<Color>, modifier: Modifier = Modifier) {
    val animatedProgress = remember { Animatable(0f) }
    val brush = getBrush(colors, 80.dp)

    LaunchedEffect(Unit) {
        animatedProgress.animateTo(
            targetValue = 1f,
            animationSpec = infiniteRepeatable(
                animation = tween(durationMillis = 20000, easing = LinearEasing),
            ),
        )
    }

    val dotInfos = remember {
        (0 until NUM_DOTS).map {
            val azimuthAngle = acos((Math.random().toFloat() * 2) - 1)
            val polarAngle = Math.random().toFloat() * TWO_PI
            DotInfo(azimuthAngle, polarAngle)
        }
    }

    Canvas(modifier = modifier) {
        // Compute the animated rotation about the y-axis in radians.
        val rotationY = animatedProgress.value * TWO_PI
        dotInfos.forEach {
            val minSize = size.minDimension
            val globeRadius = minSize * GLOBE_RADIUS_FACTOR

            // Calculate the dot's coordinates in 3D space.
            val x = globeRadius * sin(it.azimuthAngle) * cos(it.polarAngle)
            val y = globeRadius * sin(it.azimuthAngle) * sin(it.polarAngle)
            val z = globeRadius * cos(it.azimuthAngle) - globeRadius

            // Rotate the dot's 3D coordinates about the y-axis.
            val rotatedX = cos(rotationY) * x + sin(rotationY) * (z + globeRadius)
            val rotatedZ = -sin(rotationY) * x + cos(rotationY) * (z + globeRadius) - globeRadius

            // Project the rotated 3D coordinates onto the 2D plane.
            val fieldOfView = minSize * FIELD_OF_VIEW_FACTOR
            val projectedScale = fieldOfView / (fieldOfView - rotatedZ)
            val projectedX = (rotatedX * projectedScale) + minSize / 2f
            val projectedY = (y * projectedScale) + minSize / 2f

            // Scale the dot such that dots further away from the camera appear smaller.
            val dotRadius = minSize * DOT_RADIUS_FACTOR
            val scaledDotRadius = dotRadius * projectedScale

            val offset = Offset(projectedX, projectedY)
            if (offset != Offset.Unspecified) {
                drawCircle(
                    brush = brush,
                    radius = scaledDotRadius,
                    center = offset,
                )
            }
        }
    }
}


@Composable
fun getBrush(colors: List<Color>, size: Dp): Brush {
    val currentFontSizePx = with(LocalDensity.current) { size.toPx() }
    val currentFontSizeDoublePx = currentFontSizePx * 2

    val infiniteTransition = rememberInfiniteTransition(label = "")
    val offset by infiniteTransition.animateFloat(
        initialValue = 0f,
        targetValue = currentFontSizeDoublePx,
        animationSpec = infiniteRepeatable(tween(5000, easing = LinearEasing)),
        label = ""
    )

    return Brush.linearGradient(
        colors = colors,
        start = Offset(offset, offset),
        end = Offset(offset + currentFontSizePx, offset + currentFontSizePx),
        tileMode = TileMode.Mirror
    )
}

private data class DotInfo(val azimuthAngle: Float, val polarAngle: Float)
