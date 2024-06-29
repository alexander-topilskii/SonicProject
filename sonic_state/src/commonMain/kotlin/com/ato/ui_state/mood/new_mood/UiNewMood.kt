package com.ato.ui_state.mood.new_mood

data class UiNewMood(
    val currentMoodValue: Double,
    val defaultMoodValue: Double,
    val steps: Long,
    val range: ClosedFloatingPointRange<Double>,
    val id: Long = 0
)

