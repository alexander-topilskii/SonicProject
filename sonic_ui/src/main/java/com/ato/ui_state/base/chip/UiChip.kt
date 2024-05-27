package com.ato.ui_state.base.chip

import com.ato.ui_state.Ui

data class UiChip(
    val text: String,
    val isSelected: Boolean,
    override val id: Long = 0L
) : Ui

data class UiChipRow(
    val chips: List<UiChip>
) : Ui
