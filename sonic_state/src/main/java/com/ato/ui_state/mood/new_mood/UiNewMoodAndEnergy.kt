package com.ato.ui_state.mood.new_mood

data class UiNewMoodAndEnergy(
    val currentMoodValue: Double,
    val energyMoodValue: Double,
    val defaultMoodValue: Double,
    val steps: Long,
    val range: ClosedFloatingPointRange<Double>,
    val id: Long = 0
)