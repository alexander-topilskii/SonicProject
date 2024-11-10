package com.ato.sonic_ui.animations

import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection
import androidx.compose.ui.input.nestedscroll.NestedScrollSource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.Velocity
import androidx.compose.ui.unit.dp
import kotlin.math.abs


class NestedScrollAnimation(
    private val listState: LazyListState,
    private val onTargetHeightChanged: (Dp) -> Unit,
    private val minHeight: Dp = 48.dp,
    private val mediumHeight: Dp = 100.dp,
    private val maxHeight: Dp = 200.dp,
) : NestedScrollConnection {

    var animatedHeight: Dp = mediumHeight

    private var targetHeight = mediumHeight
        set(value) {
            onTargetHeightChanged(value)
            field = value
        }
    private var currentStep = CurrentStep.MEDIUM
    private var goingToMin = false


    override fun onPreScroll(available: Offset, source: NestedScrollSource): Offset {
        val dragAmount = available.y

        if (listState.firstVisibleItemIndex == 0 && listState.firstVisibleItemScrollOffset == 0) {
            val nextTarget = targetHeight + dragAmount.dp

            when {
                // Если куда мы направляемся больше медиума но мы сейчас движемся из позиции Min
                nextTarget > mediumHeight && currentStep == CurrentStep.MIN -> {
                    targetHeight = mediumHeight
                    goingToMin = false
                    return available.copy(y = dragAmount)
                }

                currentStep == CurrentStep.MAX -> {
                    targetHeight = minHeight
                    goingToMin = false
                    return available.copy(y = dragAmount)
                }

                nextTarget < minHeight && animatedHeight != targetHeight -> {
                    targetHeight = minHeight
                    goingToMin = true
                    return available.copy(y = 0f)
                }

                nextTarget < minHeight && animatedHeight == targetHeight -> {
                    targetHeight = minHeight
                    goingToMin = true
                    return available.copy(y = 0f)
                }

                nextTarget > maxHeight && animatedHeight != targetHeight -> {
                    targetHeight = maxHeight
                    goingToMin = false
                    return available.copy(y = dragAmount)
                }

                nextTarget > maxHeight && animatedHeight == targetHeight -> {
                    targetHeight = maxHeight
                    goingToMin = false
                    return available.copy(y = 0f)
                }

                else -> {
                    targetHeight = nextTarget
                    goingToMin = false
                    return available.copy(y = dragAmount)
                }
            }
        } else {
            return Offset.Zero
        }
    }

    override suspend fun onPreFling(available: Velocity): Velocity {
        if (animatedHeight != targetHeight && !goingToMin) {
            // останавливаем Fling если человек бесконечно скроллит
            return available
        }
        return super.onPreFling(available)
    }

    override suspend fun onPostFling(consumed: Velocity, available: Velocity): Velocity {
        val distanceToMax = abs(targetHeight.value - maxHeight.value)
        val distanceToMedium = abs(targetHeight.value - mediumHeight.value)
        val distanceToMin = abs(targetHeight.value - minHeight.value)

        val epsilon = 1e-6f
        when {
            abs(
                distanceToMin - minOf(distanceToMin, distanceToMedium, distanceToMax)
            ) < epsilon -> {
                targetHeight = minHeight
                currentStep = CurrentStep.MIN
            }

            abs(
                distanceToMedium - minOf(distanceToMin, distanceToMedium, distanceToMax)
            ) < epsilon -> {
                targetHeight = mediumHeight
                currentStep = CurrentStep.MEDIUM
            }

            else -> {
                targetHeight = maxHeight
                currentStep = CurrentStep.MAX
            }
        }

        return super.onPostFling(consumed, available)
    }
}


enum class CurrentStep {
    MIN, MEDIUM, MAX
}
