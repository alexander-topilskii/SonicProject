package com.ato.ui_state.base.input

import com.ato.ui_state.Ui
import com.ato.ui_state.base.text.UiSimpleText
import org.jetbrains.compose.resources.StringResource

data class UiCheckBox(
    val isChecked: Boolean,
    val description: UiSimpleText?,
    val textToCheck: Boolean = true
) : Ui