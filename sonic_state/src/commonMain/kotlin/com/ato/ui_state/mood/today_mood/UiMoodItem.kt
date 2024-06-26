package com.ato.ui_state.mood.today_mood


sealed class UiMoodItem {
    data class UiOldMoodItem(
        val id: Long = 0L,
        val moodText: String,
        val timeText: String,
        val circleColors: List<Long>
    ): UiMoodItem()

    data class UiAddMissedMoodItem(
        val addMoodText: String,
        val circleColor: Long,
    ): UiMoodItem()
}