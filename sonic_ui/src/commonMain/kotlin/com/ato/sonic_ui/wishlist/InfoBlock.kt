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
import com.ato.sonic_ui.base.text.DisplaySingleLineText
import com.ato.sonic_ui.base.text.DisplayText
import com.ato.ui_state.base.grid.DisplayGridInfo
import com.ato.ui_state.base.text.UiSimpleText
import com.ato.ui_state.wishlist.UiUserInfo


@Composable
fun DisplayInfoBlock(data: UiUserInfo, modifier: Modifier = Modifier) {
    Box(
        modifier = modifier,
    ) {
        Card(
            border = BorderStroke(1.dp, MaterialTheme.colorScheme.outline.copy(alpha = 0.1f)),
            modifier = Modifier,
        ) {

        }
    }
}


@Composable
fun DisplayInfoBlock(info: List<Pair<UiSimpleText, UiSimpleText>>, modifier: Modifier = Modifier) {
    Box(
        modifier = modifier,
    ) {
        Card(
            border = BorderStroke(1.dp, MaterialTheme.colorScheme.outline.copy(alpha = 0.1f)),
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
                    info.forEach { (title, _) ->
                        DisplaySingleLineText(
                            state = title,
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier.padding(vertical = 4.dp)
                        )
                    }
                }
                Column(
                    modifier = Modifier.padding(
                        start = 12.dp,
                        top = 16.dp,
                        bottom = 16.dp
                    )
                ) {
                    info.forEach { (_, subtitle) ->
                        DisplayText(
                            state = subtitle,
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier.padding(vertical = 4.dp).fillMaxWidth()
                        )
                    }
                }
            }
        }
    }
}