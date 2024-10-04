package com.ato.sonic_ui.base.image

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
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.skydoves.landscapist.ImageOptions
import com.skydoves.landscapist.coil3.CoilImage


@Composable
fun DisplayUserAvaWithCross(
    avaUrl: String? = null,
    avaFile: ByteArray? = null,
    onAvaClicked: () -> Unit = {},
    onClearClicked: () -> Unit = {},
    size: Float = 256f,
    sizeFactor: Float = 0.5f,
    modifier: Modifier = Modifier,
) {
    val data = avaFile ?: avaUrl
    Box(
        modifier = modifier
    ) {
        Box(
            modifier = Modifier
                .background(color = Color.Transparent, shape = CircleShape)
                .border(
                    border = BorderStroke(
                        width = 1.dp,
                        color = MaterialTheme.colorScheme.outline.copy(alpha = 0.2f)
                    ), shape = CircleShape
                )
                .size(size.dp)
                .clickable(
                    indication = null,
                    interactionSource = remember { MutableInteractionSource() },
                    onClick = onAvaClicked
                )
                .align(Alignment.Center)
        ) {
            if (data == null) {
                Text(
                    text = "+",
                    color = MaterialTheme.colorScheme.outline.copy(alpha = 0.2f),
                    textAlign = TextAlign.Center,
                    fontSize = (size * sizeFactor).sp,
                    modifier = Modifier
                        .align(Alignment.Center)
                )
            } else {
                CoilImage(
                    modifier = Modifier
                        .clip(CircleShape)
                        .size(size.dp),
                    imageModel = { data },
                    imageOptions = ImageOptions(
                        contentScale = ContentScale.Crop,
                        alignment = Alignment.Center
                    )
                )
            }

        }

        if (data != null) {
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
                        color = Color.Black.copy(alpha = 0.1f),
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
                .background(color = Color.Transparent, shape = CircleShape)
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

