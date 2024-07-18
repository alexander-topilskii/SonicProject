package com.ato.ui_state.base.chip

import com.ato.ui_state.Ui

data class UiChip<T>(
    val text: String,
    val isSelected: Boolean,
    val meta: T? = null,
    override val id: Long = 0L
) : Ui

data class UiChipRow<T>(
    val chips: List<UiChip<T>>
) : Ui
