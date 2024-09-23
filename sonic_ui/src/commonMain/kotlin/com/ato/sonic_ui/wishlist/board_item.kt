package com.ato.sonic_ui.wishlist

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.ato.sonic_ui.base.emoji.DisplayEmojiAva
import com.ato.sonic_ui.base.text.DisplayText
import com.ato.ui_state.wishlist.UiBoard


@Composable
fun DisplayBoard(
    state: UiBoard,
    onAddClicked: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Card(
        modifier = modifier,
        shape = RoundedCornerShape(8.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Display the emoji if it's not null
            if (state.boardEmoji != null) {
                DisplayEmojiAva(
                    size = 60f,
                    sizeFactor = 0.7f,
                    emoji = state.boardEmoji,
                    boarderAlpha = 0f,
                )
            }

            Spacer(modifier = Modifier.width(16.dp)) // Space between emoji and texts

            Column(
                modifier = Modifier.weight(1f) // Take up remaining horizontal space
            ) {
                // Display the board name
                DisplayText(
                    state = state.boardName,
                    style = MaterialTheme.typography.titleLarge,
                    color = MaterialTheme.colorScheme.onSurface
                )

                Spacer(modifier = Modifier.height(4.dp)) // Small space between name and count

                // Display the count of wishes
                DisplayText(
                    state = state.boardWishCount,
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.7f)
                )
            }
            Spacer(modifier = Modifier.width(8.dp)) // Space between emoji and texts

            CenteredIconCard(
                elevation = CardDefaults.cardElevation(8.dp),
                icon = Icons.Filled.Add,
                onClick = onAddClicked,
                modifier = Modifier
                    .height(60.dp)
                    .width(60.dp)
            )
        }
    }
}