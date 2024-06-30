package com.ato.ui_state.ikirag

import com.ato.ui_state.Ui
import org.jetbrains.compose.resources.StringResource

data class ProgressInfoBlock(
    val text: StringResource,
    val progress: Int,
) : Ui