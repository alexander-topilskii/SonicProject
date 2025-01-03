package com.ato.sonic_ui.base.emoji

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun DisplayEmojiAvaWithCross(
    emoji: String?,
    colors: List<Color> = listOf(
        Color.Transparent,
        Color.Transparent
    ),
    onEmojiClicked: () -> Unit,
    onClearClicked: () -> Unit,
    size: Float,
    sizeFactor: Float = 0.5f,
    modifier: Modifier = Modifier,
) {
    Box(
        modifier = modifier
    ) {
        Box(
            modifier = Modifier
                .border(
                    border = BorderStroke(
                        width = 1.dp,
                        color = MaterialTheme.colorScheme.outline.copy(alpha = 0.2f)
                    ),
                    shape = CircleShape
                )
                .background(
                    brush = Brush.linearGradient(
                        colors
                    ),
                    shape = CircleShape
                )
                .size(size.dp)
                .clickable(
                    indication = null,
                    interactionSource = remember { MutableInteractionSource() },
                    onClick = onEmojiClicked
                )
                .align(Alignment.Center)
        ) {
            Text(
                text = emoji ?: "+",
                color = if (emoji == null) MaterialTheme.colorScheme.outline.copy(alpha = 0.2f) else Color.Unspecified,
                textAlign = TextAlign.Center,
                fontSize = (size * sizeFactor).sp,
                modifier = Modifier
                    .align(Alignment.Center)

            )
        }

        if (emoji != null) {
            Box(
                modifier = Modifier
                    .clickable(
                        indication = null,
                        interactionSource = remember { MutableInteractionSource() },
                        onClick = onClearClicked
                    )
                    .size(24.dp)
                    .align(Alignment.TopEnd)
                    .background(
                        color = MaterialTheme.colorScheme.background,
                        shape = CircleShape)
                    .background(
                        color = Color.Black.copy(alpha = 0.3f),
                        shape = CircleShape
                    ),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    modifier = Modifier.padding(2.dp),
                    imageVector = Icons.Default.Close,
                    contentDescription = null
                )
            }
        }
    }
}


@Composable
fun DisplayEmojiAva(
    emoji: String?,
    colors: List<Color> = listOf(
        Color.Transparent,
        Color.Transparent
    ),
    size: Float,
    sizeFactor: Float,
    modifier: Modifier = Modifier,
    boarderAlpha: Float = 0.1f,
) {
    Box(
        modifier = modifier
    ) {
        Box(
            modifier = Modifier
                .background(
                    brush = Brush.linearGradient(colors),
                    shape = CircleShape
                )
                .border(
                    border = BorderStroke(
                        width = 1.dp,
                        color = MaterialTheme.colorScheme.outline.copy(alpha = boarderAlpha)
                    ), shape = CircleShape
                )
                .size(size.dp)
                .align(Alignment.Center)
        ) {
            Text(
                text = emoji ?: "",
                textAlign = TextAlign.Center,
                fontSize = (size * sizeFactor).sp,
                modifier = Modifier
                    .align(Alignment.Center)

            )
        }
    }
}