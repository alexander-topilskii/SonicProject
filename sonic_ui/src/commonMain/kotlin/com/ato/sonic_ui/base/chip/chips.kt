package com.ato.sonic_ui.base.chip

import androidx.compose.material3.FilterChip
import androidx.compose.material3.FilterChipDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import com.ato.ui_state.base.chip.UiIconChip
import com.ato.ui_state.base.chip.UiTextChip
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
fun <T> UiTextChip<T>.Display(onClick: (UiTextChip<T>) -> Unit) {
    FilterChip(
        colors = FilterChipDefaults.filterChipColors(
            selectedContainerColor = MaterialTheme.colorScheme.primary,
            selectedLabelColor = MaterialTheme.colorScheme.onPrimary,
        ),
        onClick = {
            onClick.invoke(this)
        },
        label = { Text(text) },
        selected = isSelected
    )
}


@Composable
fun <T> DisplayUiTextChip(state: UiTextChip<T>, onClick: (UiTextChip<T>) -> Unit) {
    FilterChip(
        colors = FilterChipDefaults.filterChipColors(
            selectedContainerColor = MaterialTheme.colorScheme.primary,
            selectedLabelColor = MaterialTheme.colorScheme.onPrimary,
        ),
        onClick = {
            onClick.invoke(state)
        },
        label = { Text(state.text) },
        selected = state.isSelected
    )
}

@Composable
fun <T> DisplayUiIconChip(state: UiIconChip<T>, onClick: (UiIconChip<T>) -> Unit) {
    FilterChip(
        colors = FilterChipDefaults.filterChipColors(
            selectedContainerColor = MaterialTheme.colorScheme.primary,
            selectedLabelColor = MaterialTheme.colorScheme.onPrimary,
        ),
        onClick = {
            onClick.invoke(state)
        },
        label = { Icon(state.icon, contentDescription = null) },
        selected = state.isSelected
    )
}

// ------------------------------------------------------------------------
// ------------------------------------------------------------------------
// ------------------------------------------------------------------------

@Preview()
@Composable
fun UiChipDemo() {
    UiTextChip<Any>("red", true).Display({})
}
