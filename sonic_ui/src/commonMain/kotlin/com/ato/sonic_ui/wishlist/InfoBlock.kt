package com.ato.sonic_ui.wishlist

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.ato.ui_state.wishlist.UiUserInfo
import org.jetbrains.compose.resources.stringResource


@Composable
fun DisplayInfoBlock(data: UiUserInfo, modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .padding(horizontal = 16.dp),
    ) {
        Card(
            border = BorderStroke(1.dp, MaterialTheme.colorScheme.primary),
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
                    Text(
                        text = stringResource(data.nameTitle),
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.padding(vertical = 4.dp)
                    )
                    Text(
                        text = stringResource(data.nickTitle),
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.padding(vertical = 4.dp)
                    )
                    data.emailTitle?.let {
                        Text(
                            text = stringResource(it),
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
                    data.name?.let {
                        Text(
                            text = it,
                            modifier = Modifier.padding(vertical = 4.dp).fillMaxWidth()
                        )
                    }
                    data.nick?.let {
                        Text(
                            text = "@$it",
                            modifier = Modifier.padding(vertical = 4.dp).fillMaxWidth()
                        )
                    }
                    data.email?.let {
                        Text(
                            text = it,
                            modifier = Modifier.padding(vertical = 4.dp).fillMaxWidth()
                        )
                    }
                }
            }
        }
    }
}