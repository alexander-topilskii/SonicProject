package com.ato.ui_state.base.button

import com.ato.ui_state.Ui
import org.jetbrains.compose.resources.StringResource

data class UiButton(
    val title: StringResource,
    val key: String? = null,
    val isEnabled: Boolean = true,
    val isLoading: Boolean = false
): Ui


