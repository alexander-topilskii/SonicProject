package com.ato.sonic_ui.base.sliders

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Slider
import androidx.compose.material3.SliderDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableDoubleStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.ato.ui_state.base.sliders.UiLessMoreSlider
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
fun UiLessMoreSlider.Display(onChange: (Double) -> Unit, modifier: Modifier = Modifier) {
    Slider(
        value = value.toFloat(),
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

@Preview()
@Composable
fun UiLessMoreSliderPreview() {
    var sliderPosition by remember { mutableDoubleStateOf(0.0) }

    UiLessMoreSlider(
        value = sliderPosition,
        defaultValue = 4.0,
        steps = 5L,
        range = 1.0..5.0,
    ).Display({
        sliderPosition = it
    })
}