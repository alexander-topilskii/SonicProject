package com.ato.sonic_ui.mood.mood_energy

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.ato.ui_state.mood.UiMoodAndEnergyItem
import com.ato.ui_state.mood.UiMoodAndEnergyList

@Composable
fun UiMoodAndEnergyList.Display(
    onClicked: (UiMoodAndEnergyItem) -> Unit = {},
    modifier: Modifier = Modifier,
) {
    LazyColumn(modifier) {
        items(moods) { item ->
            item.Display(modifier, onClicked)
        }
    }
}

// ------------------------------------------------------------------------
// ------------------------------------------------------------------------
// ------------------------------------------------------------------------


@Preview(showBackground = true)
@Composable
private fun Preview() {
    UiMoodAndEnergyList(
        moods = listOf(
            UiMoodAndEnergyItem(
                moodText = "Your mood was 5.0",
                energyText = "Your energy was 4.0"
            ),
            UiMoodAndEnergyItem(
                moodText = "Your mood was 5.0",
                energyText = "Your energy was 4.0"
            ),
            UiMoodAndEnergyItem(
                moodText = "Your mood was 5.0",
                energyText = "Your energy was 4.0"
            ),
            UiMoodAndEnergyItem(
                moodText = "Your mood was 5.0",
                energyText = "Your energy was 4.0"
            ),
            UiMoodAndEnergyItem(
                moodText = "Your mood was 5.0",
                energyText = "Your energy was 4.0"
            ),
        )
    ).Display()
}