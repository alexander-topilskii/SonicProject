package com.ato.ui_state.base.input

import androidx.compose.ui.text.input.KeyboardType
import com.ato.ui_state.Ui

data class UiEditTextState(
    val title: String,
    val inputText: String,
    val maxLines: Int = Int.MAX_VALUE,
    val minLines: Int = 1,
    val singleLine: Boolean = false,
    val keyboardType: KeyboardType = KeyboardType.Text
): Ui