package com.ato.ui_state.base.text

import com.ato.ui_state.base.button.UiButton
import org.jetbrains.compose.resources.StringResource

data class UiTitle(
    val title: StringResource,
    val button: UiButton?,
)