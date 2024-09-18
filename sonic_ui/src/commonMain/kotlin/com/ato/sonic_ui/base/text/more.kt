package com.ato.sonic_ui.base.text

import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.Row
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.ato.sonic_ui.base.icons.DisplayIcon
import com.ato.ui_state.base.text.UiMoreText

@Composable
fun DisplayMore(
    state: UiMoreText,
    modifier: Modifier = Modifier,
    color: Color = MaterialTheme.colorScheme.outline,
    content:  @Composable BoxScope.()->Unit = {},
    onClicked: () -> Unit
) {
    Box(modifier = modifier) {
        content()
        Row(
            modifier = Modifier
                .align(Alignment.TopEnd)
                .clickable(
                    indication = null,
                    interactionSource = remember { MutableInteractionSource() },
                    onClick = onClicked
                )
        ) {
            DisplayText(state = state.text, color = color)
            DisplayIcon(state = state.icon, tint = color)
        }
    }
}