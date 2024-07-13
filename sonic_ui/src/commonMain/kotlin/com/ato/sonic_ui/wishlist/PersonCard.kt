package com.ato.sonic_ui.wishlist

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.ato.sonic_ui.base.button.DisplayButton
import com.ato.ui_state.base.button.UiButton

@Composable
fun PersonCard(
    name: String,
    nick: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier,
        border = BorderStroke(1.dp, MaterialTheme.colorScheme.outline),
        onClick = onClick
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
            text = "@${nick}",
            modifier = Modifier
                .padding(horizontal = 8.dp)
                .padding(bottom = 8.dp)
        )
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
    onDecline: () -> Unit,
    onBlock: () -> Unit,
) {
    Card(
        modifier = modifier,
        border = BorderStroke(1.dp, MaterialTheme.colorScheme.outline),
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
                onClick = onDecline
            )
            DisplayButton(
                state = declineButton,
                onClick = onBlock
            )
        }

        Spacer(modifier = Modifier.height(8.dp))
    }
}