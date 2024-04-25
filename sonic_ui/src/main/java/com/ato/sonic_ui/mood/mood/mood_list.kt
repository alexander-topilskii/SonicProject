package com.ato.sonic_ui.mood.mood

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.ato.ui_state.mood.UiMoodItem
import com.ato.ui_state.mood.UiMoodList


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

@Preview(showBackground = true)
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

