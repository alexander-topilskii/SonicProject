package com.ato.sonic_ui.wishlist

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.ato.sonic_ui.base.text.DisplayText
import com.ato.ui_state.wishlist.UiBoardInfo


@Composable
fun DisplayBoardInfoBlock(data: UiBoardInfo, modifier: Modifier = Modifier) {
    Box(
        modifier = modifier,
    ) {
        Card(
            border = BorderStroke(1.dp, MaterialTheme.colorScheme.outline),
            modifier = Modifier,
        ) {
            Row {
                Column(
                    modifier = Modifier.padding(
                        start = 12.dp,
                        top = 16.dp,
                        bottom = 16.dp
                    )
                ) {

                    DisplayText(
                        state = data.nameTitle,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.padding(vertical = 4.dp)
                    )
                    DisplayText(
                        state = data.wishCountTitle,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.padding(vertical = 4.dp)
                    )
                    DisplayText(
                        state = data.completedWishTitle,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.padding(vertical = 4.dp)
                    )
                    DisplayText(
                        state = data.takenWishCountTitle,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.padding(vertical = 4.dp)
                    )
                    DisplayText(
                        state = data.privacyTitle,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.padding(vertical = 4.dp)
                    )
                }
                Column(
                    modifier = Modifier.padding(
                        start = 12.dp,
                        top = 16.dp,
                        bottom = 16.dp
                    )
                ) {
                    DisplayText(
                        state = data.name,
                        modifier = Modifier.padding(vertical = 4.dp).fillMaxWidth()
                    )
                    DisplayText(
                        state = data.wishCount,
                        modifier = Modifier.padding(vertical = 4.dp).fillMaxWidth()
                    )
                    DisplayText(
                        state = data.completedWish,
                        modifier = Modifier.padding(vertical = 4.dp).fillMaxWidth()
                    )
                    DisplayText(
                        state = data.takenWishCount,
                        modifier = Modifier.padding(vertical = 4.dp).fillMaxWidth()
                    )
                    DisplayText(
                        state = data.privacy,
                        modifier = Modifier.padding(vertical = 4.dp).fillMaxWidth()
                    )
                }
            }
        }
    }
}
