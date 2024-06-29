package com.ato.ui_state.base.button

import com.ato.ui_state.Ui

data class UiButton(
    val title: String,
    val key: String? = null,
    val isEnabled: Boolean = true,
    val isLoading: Boolean = false
): Ui

