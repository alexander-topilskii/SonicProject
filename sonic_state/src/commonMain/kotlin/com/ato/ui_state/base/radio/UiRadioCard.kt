package com.ato.ui_state.base.radio

import androidx.compose.ui.graphics.vector.ImageVector
import com.ato.ui_state.Ui
import org.jetbrains.compose.resources.StringResource

data class UiRadioCard(
    val text: StringResource,
    val formatArgs: String? = null,
    val icon: ImageVector? = null,
    val isSelected: Boolean,
    val meta: Any? = null
): Ui