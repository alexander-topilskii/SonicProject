package com.ato.sonic_ui.wishlist

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.ato.helpers.formatDate
import com.ato.ui_state.wishlist.WishlistEvent
import dev.gitlive.firebase.firestore.toMilliseconds


@Composable
fun DisplayEvent(
    state: WishlistEvent,
    colors: CardColors = CardDefaults.cardColors(),
    modifier: Modifier = Modifier) {
    Card(
        modifier = modifier,
        colors = colors
    ) {
        Column(Modifier.padding(vertical = 8.dp, horizontal = 16.dp)) {
            Text(
                text = state.name ?: "",
                fontWeight = FontWeight.Bold,
            )
            state.eventDate?.let { dateMs ->
                Text(
                    text = formatDate(dateMs.toMilliseconds()),
                )
            }
        }
    }
}