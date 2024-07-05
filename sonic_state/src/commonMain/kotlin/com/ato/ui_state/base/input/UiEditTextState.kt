package com.ato.ui_state.base.input

import com.ato.ui_state.Ui
import com.ato.ui_state.base.UiIcon
import org.jetbrains.compose.resources.StringResource

data class UiEditTextState(
    val title: StringResource,
    val inputText: String,
    val keyboardType: Any,
    val maxLines: Int = Int.MAX_VALUE,
    val minLines: Int = 1,
    val singleLine: Boolean = false,
    val errorText: StringResource? = null,
    val endIcon: UiIcon? = null
): Ui