package com.ato.ui_state.base.input

import com.ato.ui_state.Ui
import org.jetbrains.compose.resources.StringResource

data class UiCheckBox(
    val isChecked: Boolean,
    val description: StringResource?,
    val textToCheck: Boolean = true
) : Ui