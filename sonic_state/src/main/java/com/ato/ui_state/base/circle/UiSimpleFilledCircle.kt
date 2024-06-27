package com.ato.ui_state.base.circle

import androidx.compose.ui.graphics.Color

data class UiSimpleFilledCircle(
    val color: Color
)

data class UiSimpleOutlinedCircle(
    val color: Color,
    val width: Float
)

data class UiGradientCircle(
    val colors: List<Color>,
)
