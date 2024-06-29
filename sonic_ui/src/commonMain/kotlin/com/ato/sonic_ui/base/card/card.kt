package com.ato.sonic_ui.base.card

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.ato.ui_state.base.card.UiDeleteCard
import org.jetbrains.compose.ui.tooling.preview.Preview


@Composable
fun UiDeleteCard.Display(
    onDeleteClicked: (UiDeleteCard) -> Unit,
    onChangeReactionClicked: (UiDeleteCard) -> Unit,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier
    ) {
        Row {
            Row(
                Modifier
                    .fillMaxWidth()
                    .padding(all = 16.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                val icon = remember(isLiked) {
                    when (isLiked) {
                        true -> Icons.Filled.Favorite
                        false -> Icons.Filled.Clear
                        else -> null
                    }
                }

                Text(
                    modifier = Modifier.weight(1f),
                    text = content,
                    textAlign = TextAlign.Center
                )
                Column {
                    Icon(
                        modifier = Modifier
                            .defaultMinSize(16.dp)
                            .padding(8.dp)
                            .clickable {
                                onDeleteClicked.invoke(this@Display)
                            },
                        imageVector = Icons.Default.Delete,
                        contentDescription = "Delete"
                    )
                    icon?.let {
                        Spacer(modifier = Modifier.height(16.dp))
                        Icon(
                            modifier = Modifier
                                .defaultMinSize(16.dp)
                                .padding(8.dp)
                                .clickable {
                                    onChangeReactionClicked.invoke(this@Display)
                                },
                            imageVector = icon,
                            contentDescription = "Delete"
                        )
                    }
                }
            }
        }
    }
}


@Preview()
@Composable
fun UiDeleteCardPreview() {
    UiDeleteCard("TexttTextTextTextTextTextTextText", id = 0L, isLiked = true).Display({}, {})
}
