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
import com.ato.ui_state.base.chip.UiIconChip
import com.ato.ui_state.base.chip.UiTextChip
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
        chips.forEach {
            when (it) {
                is UiTextChip -> DisplayUiTextChip(it, onTagClicked)
                is UiIconChip -> DisplayUiIconChip(it, onTagClicked)
            }
        }
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
        horizontalArrangement = Arrangement.spacedBy(4.dp),
        modifier = modifier
    ) {
        chipsRow.chips.forEach {
            when (it) {
                is UiTextChip -> DisplayUiTextChip(it, onTagClicked)
                is UiIconChip -> DisplayUiIconChip(it, onTagClicked)
            }
        }
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
            UiTextChip(isSelected = false, text = "green"),
            UiTextChip(isSelected = true, text = "red"),
            UiTextChip(isSelected = false, text = "orange"),
            UiTextChip(isSelected = false, text = "blue"),
            UiTextChip(isSelected = false, text = "green"),
            UiTextChip(isSelected = false, text = "red"),
            UiTextChip(isSelected = false, text = "orange"),
            UiTextChip(isSelected = false, text = "blue"),
        )
    ).Display({})
}
