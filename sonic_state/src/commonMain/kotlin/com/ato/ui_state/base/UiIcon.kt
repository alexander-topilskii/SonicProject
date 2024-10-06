package com.ato.ui_state.base

import androidx.compose.ui.graphics.vector.ImageVector

data class UiIcon(
    val icon: ImageVector,
    val contentDescription: String = "",
    val isLoading: Boolean = false
)
