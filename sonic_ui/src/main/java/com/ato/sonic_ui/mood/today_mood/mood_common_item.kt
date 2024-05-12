package com.ato.sonic_ui.mood.today_mood

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.ato.ui_state.mood.today_mood.UiMoodItem


@Composable
fun UiMoodItem.Display(onClicked: (UiMoodItem) -> Unit, modifier: Modifier = Modifier) {
    when (this) {
        is UiMoodItem.UiOldMoodItem -> this.Display(onClicked, modifier)
        is UiMoodItem.UiAddMissedMoodItem -> this.Display(onClicked, modifier)
    }
}