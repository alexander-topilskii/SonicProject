package com.ato.ui_state.base.input

import com.ato.ui_state.Ui
import com.ato.ui_state.base.UiIcon

data class UiEditTextState(
    val title: String,
    val inputText: String,
    val maxLines: Int = Int.MAX_VALUE,
    val minLines: Int = 1,
    val singleLine: Boolean = false,
    val keyboardType: Any,
    val endIcon: UiIcon? = null
): Ui