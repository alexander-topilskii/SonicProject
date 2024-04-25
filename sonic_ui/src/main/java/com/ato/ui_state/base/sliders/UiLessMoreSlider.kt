package com.ato.ui_state.base.sliders

data class UiLessMoreSlider(
    val value: Double,
    val defaultValue: Double,
    val steps: Long,
    val range: ClosedFloatingPointRange<Double>,
    val id: Long = 0
)
