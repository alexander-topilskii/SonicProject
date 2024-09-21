package com.ato.ui_state.base.text

import com.ato.ui_state.Button
import com.ato.ui_state.base.button.UiButton
import org.jetbrains.compose.resources.StringResource

data class UiTitle(
    val title: StringResource,
    val titleFormatArgs: String? = null,
    val button: Button? = null,
)