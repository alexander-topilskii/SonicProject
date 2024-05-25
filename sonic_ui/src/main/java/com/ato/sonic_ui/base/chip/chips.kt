package com.ato.sonic_ui.base.chip

import androidx.compose.material3.FilterChip
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.tooling.preview.Preview
import com.ato.ui_state.base.chip.UiChip

@Composable
fun UiChip.Display(onClick: (UiChip) -> Unit) {
    var selected by remember { mutableStateOf(false) }

    FilterChip(
        onClick = {
            selected = !selected
            onClick.invoke(this)
        },
        label = { Text(text) },
        selected = selected
    )
}

// ------------------------------------------------------------------------
// ------------------------------------------------------------------------
// ------------------------------------------------------------------------

@Preview(showBackground = true)
@Composable
fun UiChipDemo() {
    UiChip("red").Display({})
}
