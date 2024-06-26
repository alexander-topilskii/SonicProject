package com.ato.sonic_ui.mood.new_mood

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Slider
import androidx.compose.material3.SliderDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.ato.ui_state.mood.new_mood.UiNewMoodAndEnergy
import org.jetbrains.compose.ui.tooling.preview.Preview


@Composable
fun UiNewMoodAndEnergy.Display(
    onChangeMood: (Double) -> Unit,
    onChangeEnergy: (Double) -> Unit,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier) {
        Slider(
            value = currentMoodValue.toFloat(),
            onValueChange = { onChangeMood(it.toDouble()) },
            colors = SliderDefaults.colors(
                thumbColor = MaterialTheme.colorScheme.secondary,
                activeTrackColor = MaterialTheme.colorScheme.secondary,
                inactiveTrackColor = MaterialTheme.colorScheme.secondaryContainer,
            ),
            steps = steps.toInt(),
            valueRange = range.start.toFloat()..range.endInclusive.toFloat(),
        )
        Slider(
            value = energyMoodValue.toFloat(),
            onValueChange = { onChangeEnergy(it.toDouble()) },
            colors = SliderDefaults.colors(
                thumbColor = MaterialTheme.colorScheme.secondary,
                activeTrackColor = MaterialTheme.colorScheme.secondary,
                inactiveTrackColor = MaterialTheme.colorScheme.secondaryContainer,
            ),
            steps = steps.toInt(),
            valueRange = range.start.toFloat()..range.endInclusive.toFloat(),
        )
    }
}


// ------------------------------------------------------------------------
// ------------------------------------------------------------------------
// ------------------------------------------------------------------------

@Preview()
@Composable
private fun Preview() {
    UiNewMoodAndEnergy(
        currentMoodValue = 2.0,
        energyMoodValue = 3.0,
        defaultMoodValue = 3.0,
        steps = 3,
        range = 1.0..5.0
    ).Display({}, {})
}