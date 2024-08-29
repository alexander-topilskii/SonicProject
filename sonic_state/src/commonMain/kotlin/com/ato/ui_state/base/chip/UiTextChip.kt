package com.ato.ui_state.base.chip

import androidx.compose.ui.graphics.vector.ImageVector
import com.ato.ui_state.Ui

data class UiTextChip<T>(
    val text: String,
    override val isSelected: Boolean,
    override val meta: T? = null,
    override val id: Long = 0L
) : UiChip<T>

data class UiIconChip<T>(
    val icon: ImageVector,
    override val isSelected: Boolean,
    override val meta: T? = null,
    override val id: Long = 0L
) : UiChip<T>

data class UiChipRow<T>(
    val chips: List<UiChip<T>>
) : Ui

interface UiChip<T> : Ui {
    val isSelected: Boolean
    val meta: T?
}