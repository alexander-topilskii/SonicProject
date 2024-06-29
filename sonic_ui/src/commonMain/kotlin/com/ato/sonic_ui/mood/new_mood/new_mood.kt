package com.ato.sonic_ui.mood.new_mood

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Slider
import androidx.compose.material3.SliderDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.ato.ui_state.mood.new_mood.UiNewMood
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
fun UiNewMood.Display(
    onChange: (Double) -> Unit,
    modifier: Modifier = Modifier
) {
    Slider(
        value = currentMoodValue.toFloat(),
        onValueChange = { onChange(it.toDouble()) },
        colors = SliderDefaults.colors(
            thumbColor = MaterialTheme.colorScheme.secondary,
            activeTrackColor = MaterialTheme.colorScheme.secondary,
            inactiveTrackColor = MaterialTheme.colorScheme.secondaryContainer,
        ),
        steps = steps.toInt(),
        valueRange = range.start.toFloat()..range.endInclusive.toFloat(),
        modifier = modifier
    )
}


// ------------------------------------------------------------------------
// ------------------------------------------------------------------------
// ------------------------------------------------------------------------

@Preview()
@Composable
private fun Preview() {
    UiNewMood(
        currentMoodValue = 2.0,
        defaultMoodValue = 3.0,
        steps = 3,
        range = 1.0..5.0
    ).Display({})
}