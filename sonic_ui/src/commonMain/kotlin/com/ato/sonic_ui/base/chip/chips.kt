package com.ato.sonic_ui.base.chip

import androidx.compose.material3.FilterChip
import androidx.compose.material3.FilterChipDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import com.ato.ui_state.base.chip.UiChip
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
fun <T> UiChip<T>.Display(onClick: (UiChip<T>) -> Unit) {
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

// ------------------------------------------------------------------------
// ------------------------------------------------------------------------
// ------------------------------------------------------------------------

@Preview()
@Composable
fun UiChipDemo() {
    UiChip<Any>("red", true).Display({})
}
