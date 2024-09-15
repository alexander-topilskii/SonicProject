package com.ato.ui_state.base.button

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import com.ato.ui_state.base.UiIcon
import com.ato.ui_state.base.text.UiSimpleText

data class UiSwipeLoadingButton(
    val text: UiSimpleText,
    val icon: UiIcon = UiIcon(
        Icons.AutoMirrored.Filled.ArrowForward,
    ),
    val isLoading: Boolean = false
)