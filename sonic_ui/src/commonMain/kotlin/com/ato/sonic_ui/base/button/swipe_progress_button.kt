package com.ato.sonic_ui.base.button

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.ato.sonic_ui.base.icons.DisplayIcon
import com.ato.sonic_ui.base.text.DisplayText
import com.ato.ui_state.base.UiIcon
import com.ato.ui_state.base.text.UiSimpleText

data class UiSwipeLoadingButton(
    val text: UiSimpleText,
    val icon: UiIcon,
    val isLoading: Boolean
)

@Composable
fun SwipeLoadingButton(
    state: UiSwipeLoadingButton,
    modifier: Modifier,
    onSwiped: () -> Unit
) {
    SwipeButton(
        contentSize = 48.dp,
        colorStart = MaterialTheme.colorScheme.surface,
        colorEnd = MaterialTheme.colorScheme.secondary,
        commonContent = {
            Column(modifier = Modifier.align(Alignment.Center)) {
                AnimatedVisibility(
                    visible = !state.isLoading,
                    exit = fadeOut()
                ) {
                    DisplayText(state.text)
                }
            }
        },
        draggableContent = { m ->
            Box(
                modifier = m
                    .padding(4.dp)
                    .background(MaterialTheme.colorScheme.primary, CircleShape),
                contentAlignment = Alignment.Center
            ) {
                if (!state.isLoading) {
                    DisplayIcon(
                        state.icon,
                        tint = MaterialTheme.colorScheme.onPrimary
                    )
                } else {
                    CircularProgressIndicator(
                        modifier = Modifier.size(ButtonDefaults.IconSize),
                        strokeWidth = 2.dp,
                        color = MaterialTheme.colorScheme.onPrimary
                    )
                }
            }
        },
        orientation = Orientation.Horizontal,
        modifier = modifier,
        onUnlock = onSwiped
    )
}