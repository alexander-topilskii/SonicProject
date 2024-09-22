package com.ato.sonic_ui.wishlist

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.ato.helpers.formatDate
import com.ato.sonic_ui.base.text.DisplayText
import com.ato.ui_state.base.text.UiSimpleText
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


@Composable
fun CenteredDateCard(
    icon: ImageVector,
    text: UiSimpleText? = null,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier,
        onClick = onClick
    ) {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Row {
                Icon(
                    imageVector = icon,
                    contentDescription = null,
                    modifier = Modifier.size(24.dp),
                    tint = MaterialTheme.colorScheme.onSurface
                )
                if (text != null) {
                    Spacer(Modifier.width(8.dp))
                    DisplayText(text)
                }
            }

        }
    }
}