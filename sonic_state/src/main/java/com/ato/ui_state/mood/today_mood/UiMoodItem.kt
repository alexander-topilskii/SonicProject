package com.ato.ui_state.mood.today_mood

import androidx.compose.ui.graphics.Color
import java.util.Calendar


sealed class UiMoodItem {
    data class UiOldMoodItem(
        val id: Long = 0L,
        val moodText: String,
        val timeText: String,
        val circleColors: List<Color>
    ): UiMoodItem()

    data class UiAddMissedMoodItem(
        val addMoodText: String,
        val circleColor: Color,
        val time: Calendar
    ): UiMoodItem()
}