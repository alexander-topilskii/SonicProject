package com.ato.sonic_ui.mood.mood_energy

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.ato.ui_state.mood.UiMoodAndEnergyItem
import org.jetbrains.compose.ui.tooling.preview.Preview


@Composable
fun UiMoodAndEnergyItem.Display(
    modifier: Modifier = Modifier,
    onClicked: (UiMoodAndEnergyItem) -> Unit = {}
) {
    Column(
        modifier = Modifier.clickable { onClicked(this) }
    ) {
        Text(
            text = this@Display.moodText,
            modifier = modifier
        )
        Text(
            text = this@Display.energyText,
            modifier = modifier
        )
        Spacer(
            modifier = Modifier
                .height(8.dp)
                .fillMaxWidth()
                .background(color = Color.Blue)
        )
    }
}

// ------------------------------------------------------------------------
// ------------------------------------------------------------------------
// ------------------------------------------------------------------------

@Preview()
@Composable
private fun Preview() {
    UiMoodAndEnergyItem(
        moodText = "Your mood was 5.0",
        energyText = "Your energy was 4.0"
    ).Display()
}
