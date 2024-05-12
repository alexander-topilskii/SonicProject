package com.ato.sonic_ui.base.card

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ato.ui_state.base.card.UiDeleteCard


@Composable
fun UiDeleteCard.Display(onDeleteClicked: (UiDeleteCard) -> Unit, modifier: Modifier = Modifier) {
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
                Text(modifier = Modifier.weight(1f), text = content, textAlign = TextAlign.Center)
                Icon(
                    modifier = Modifier
                        .defaultMinSize(16.dp)
                        .padding(start = 8.dp)
                        .clickable {
                            onDeleteClicked.invoke(this@Display)
                        },
                    imageVector = Icons.Default.Delete,
                    contentDescription = "Delete"
                )
            }
        }
    }
}


@Preview()
@Composable
fun UiDeleteCardPreview() {
    UiDeleteCard("TextTextTextTextTextTextTesdfxtTextTextTextTextTextTextText").Display({})
}
