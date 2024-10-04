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
fun DisplayUserAva(
    avaUrl: String? = null,
    onAvaClicked: () -> Unit = {},
    size: Float = 256f,
    sizeFactor: Float = 0.5f,
    modifier: Modifier = Modifier,
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
            if (avaUrl == null) {
                Text(
                    text = "?",
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
                        .border(
                            width = 2.dp,
                            color = MaterialTheme.colorScheme.surface,
                            shape = CircleShape
                        )
                        .size(size.dp),
                    imageModel = { avaUrl },
                    imageOptions = ImageOptions(
                        contentScale = ContentScale.Crop,
                        alignment = Alignment.Center
                    )
                )
            }
        }
    }
}