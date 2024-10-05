package com.ato.sonic_ui.wishlist

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.ato.sonic_ui.base.button.DisplayButton
import com.ato.sonic_ui.base.image.DisplayImage
import com.ato.ui_state.base.button.UiButton
import com.ato.ui_state.base.image.UiImagePicker

@Composable
fun PersonCard(
    name: String,
    nick: String,
    avaUrl: String?,
    onClick: (() -> Unit)? = null,
    colors: CardColors = CardDefaults.cardColors(),
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier,
        colors = colors,
        onClick = { onClick?.invoke() }
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ) {
            Column(
                modifier = Modifier.weight(1f)
            ) {
                Text(
                    text = name,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier
                        .padding(horizontal = 8.dp)
                        .padding(top = 8.dp)
                )
                Spacer(Modifier.height(2.dp))
                Text(
                    text = "@$nick",
                    modifier = Modifier
                        .padding(horizontal = 8.dp)
                        .padding(bottom = 8.dp)
                )
            }
            avaUrl?.let {
                Box(
                    modifier = Modifier.padding(8.dp).padding(end = 8.dp),
                    contentAlignment = Alignment.Center
                ) {
                    DisplayImage(
                        imagePikerState = UiImagePicker(avaUrl),
                        size = 64f
                    )
                }
            }
        }
    }
}

@Composable
fun PersonCardButtons(
    name: String,
    nick: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    acceptButton: UiButton,
    declineButton: UiButton,
    onAccept: () -> Unit,
    onDecline: () -> Unit,
) {
    Card(
        modifier = modifier,
        onClick = onClick
    ) {
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = name,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .padding(horizontal = 8.dp)
                .padding(top = 8.dp)
        )
        Spacer(Modifier.height(2.dp))
        Text(
            text = "@${nick}",
            modifier = Modifier
                .padding(horizontal = 8.dp)
                .padding(bottom = 8.dp)
        )
        Row(
            horizontalArrangement = Arrangement.SpaceAround,
            modifier = Modifier.fillMaxWidth().padding(horizontal = 16.dp)
        ) {
            DisplayButton(
                state = acceptButton,
                onClick = onAccept
            )
            DisplayButton(
                state = declineButton,
                onClick = onDecline
            )
        }

        Spacer(modifier = Modifier.height(8.dp))
    }
}