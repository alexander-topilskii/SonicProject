package com.ato.sonic_ui.mood.mood

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.ato.ui_state.mood.UiMoodItem
import com.ato.ui_state.mood.UiMoodList
import org.jetbrains.compose.ui.tooling.preview.Preview


@Composable
fun UiMoodList.Display(modifier: Modifier = Modifier) {
    LazyColumn(modifier) {
        items(moods) { item ->
            item.Display()
        }
    }
}

// ------------------------------------------------------------------------
// ------------------------------------------------------------------------
// ------------------------------------------------------------------------

@Preview()
@Composable
private fun Preview() {
    UiMoodList(
        moods = listOf(
            UiMoodItem("Your mood was 3.0"),
            UiMoodItem("Your mood was 3.0"),
            UiMoodItem("Your mood was 3.0"),
            UiMoodItem("Your mood was 3.0"),
            UiMoodItem("Your mood was 3.0"),
        )
    ).Display()
}

