package com.ato.sonic_ui.base.chip

import androidx.compose.material3.FilterChip
import androidx.compose.material3.FilterChipDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.ato.ui_state.base.chip.UiChip

@Composable
fun UiChip.Display(onClick: (UiChip) -> Unit) {
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

@Preview(showBackground = true)
@Composable
fun UiChipDemo() {
    UiChip("red", true).Display({})
}
