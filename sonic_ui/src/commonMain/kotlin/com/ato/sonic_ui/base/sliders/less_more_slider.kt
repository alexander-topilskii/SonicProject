package com.ato.sonic_ui.base.sliders

import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Slider
import androidx.compose.material3.SliderDefaults
import androidx.compose.material3.SliderState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import com.ato.ui_state.base.sliders.UiLessMoreSlider

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


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DisplaySlider(
    state: UiLessMoreSlider,
    onChange: (Double) -> Unit,
    modifier: Modifier = Modifier,
    thumb: @Composable (SliderState) -> Unit = {
        SliderDefaults.Thumb(
            interactionSource = remember { MutableInteractionSource() },
            colors = SliderDefaults.colors(),
            enabled = true
        )
    },
) {
    Slider(
        value = state.value.toFloat(),
        onValueChange = { onChange(it.toDouble()) },
        thumb = thumb,
        colors = SliderDefaults.colors(
            thumbColor = MaterialTheme.colorScheme.secondary,
            activeTrackColor = MaterialTheme.colorScheme.secondary,
            inactiveTrackColor = MaterialTheme.colorScheme.secondaryContainer,
        ),
        steps = state.steps.toInt(),
        valueRange = state.range.start.toFloat()..state.range.endInclusive.toFloat(),
        modifier = modifier
    )
}
