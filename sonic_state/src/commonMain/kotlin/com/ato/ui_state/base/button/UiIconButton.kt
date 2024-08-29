package com.ato.ui_state.base.button

import androidx.compose.ui.graphics.vector.ImageVector
import com.ato.ui_state.Button
import com.ato.ui_state.Ui
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.StringResource

data class UiIconButton(
    val icon: ImageVector,
    val key: String? = null,
    val isEnabled: Boolean = true,
    val isLoading: Boolean = false,
    val isVisible: Boolean = true
): Ui, Button


