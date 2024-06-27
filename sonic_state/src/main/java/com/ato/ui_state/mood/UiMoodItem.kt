package com.ato.ui_state.mood

import com.ato.ui_state.Ui

data class UiMoodItem(
    val text: String,
    override val id: Long = 0L,
): Ui

