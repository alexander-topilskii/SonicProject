package com.ato.ui_state.ikirag

import com.ato.ui_state.Ui
import org.jetbrains.compose.resources.StringResource

data class CountInfoBlock(
    val text: StringResource,
    val count: Int
) : Ui
