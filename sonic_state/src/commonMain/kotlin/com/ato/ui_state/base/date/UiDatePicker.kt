package com.ato.ui_state.base.date

import com.ato.ui_state.base.button.UiButton
import com.ato.ui_state.base.text.UiSimpleText

data class UiDatePicker(
    val isShown: Boolean,
    val okButton: UiButton,
    val cancelButton: UiButton,
    val date: Long? = null,
    val dateText: UiSimpleText? = null
)