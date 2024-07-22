package com.ato.sonic_ui.base.chip

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.ato.ui_state.base.chip.UiChip
import com.ato.ui_state.base.chip.UiChipRow
import org.jetbrains.compose.ui.tooling.preview.Preview

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun <T> UiChipRow<T>.Display(
    onTagClicked: (UiChip<T>) -> Unit,
    modifier: Modifier = Modifier,
) {
    FlowRow(
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        modifier = modifier.padding(8.dp)
    ) {
        chips.forEach { it.Display(onTagClicked) }
    }
}

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun <T> DisplayCenterChipRow(
    chipsRow: UiChipRow<T>,
    onTagClicked: (UiChip<T>) -> Unit,
    modifier: Modifier = Modifier,
) {
    FlowRow(
        horizontalArrangement = Arrangement.spacedBy(8.dp, Alignment.CenterHorizontally),
        modifier = modifier
    ) {
        chipsRow.chips.forEach { it.Display(onTagClicked) }
    }
}

// ------------------------------------------------------------------------
// ------------------------------------------------------------------------
// ------------------------------------------------------------------------

@Preview()
@Composable
fun UiChipRowDemo() {
    UiChipRow<Any>(
        chips = listOf(
            UiChip(isSelected = false, text = "green"),
            UiChip(isSelected = true, text = "red"),
            UiChip(isSelected = false, text = "orange"),
            UiChip(isSelected = false, text = "blue"),
            UiChip(isSelected = false, text = "green"),
            UiChip(isSelected = false, text = "red"),
            UiChip(isSelected = false, text = "orange"),
            UiChip(isSelected = false, text = "blue"),
        )
    ).Display({})
}
