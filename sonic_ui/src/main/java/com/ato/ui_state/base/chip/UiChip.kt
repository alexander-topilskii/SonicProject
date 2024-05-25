package com.ato.ui_state.base.chip

import com.ato.ui_state.Ui

data class UiChip(val text: String)

data class UiChipRow(
    val chips: List<UiChip>
) : Ui
