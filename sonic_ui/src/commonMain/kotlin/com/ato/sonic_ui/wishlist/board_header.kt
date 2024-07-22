package com.ato.sonic_ui.wishlist

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.ato.sonic_ui.base.icons.DisplayIcon
import com.ato.ui_state.base.UiIcon
import com.ato.ui_state.base.list.UiMap
import com.ato.ui_state.wishlist.WishlistBoard
import com.ato.ui_state.wishlist.WishlistWish
import org.jetbrains.compose.resources.stringResource


@Composable
fun BoardHeader(
    map: UiMap<WishlistBoard?, WishlistWish>,
    modifier: Modifier,
    board: WishlistBoard?,
    onHeaderClicked: ((WishlistBoard?) -> Unit)?,
) {

    Spacer(modifier.height(16.dp))
    Row(
        modifier = modifier
            .fillMaxWidth()
            .let {
                if (onHeaderClicked != null) {
                    it.clickable(onClick = remember(map) { { onHeaderClicked.invoke(board) } })
                } else {
                    it
                }
            },
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        if (board == null) {
            Text(
                text = map.headerTitle?.let { stringResource(it) } ?: "",
                fontWeight = FontWeight.Bold,
                modifier = Modifier.weight(1f)
            )
        } else {
            Text(
                text = board.name.orEmpty(),
                fontWeight = FontWeight.Bold,
                modifier = Modifier.weight(1f)
            )
        }
        map.headerIcon?.icon?.let { icon ->
            DisplayIcon(
                UiIcon(
                    icon = icon,
                ),
                modifier = Modifier
                    .size(36.dp)
                    .clip(CircleShape)
                    .padding(8.dp)
                    .weight(1f, fill = false),
                tint = MaterialTheme.colorScheme.onBackground
            )
        }

    }
}