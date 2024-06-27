package com.ato.ui_state.base.circle


data class UiSimpleFilledCircle(
    val color: Long
)

data class UiSimpleOutlinedCircle(
    val color: Long,
    val width: Float
)

data class UiGradientCircle(
    val colors: List<Long>,
)
