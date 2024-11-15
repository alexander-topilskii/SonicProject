package com.ato.sonic_ui.base.button

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.ato.sonic_ui.base.text.DisplaySingleLineText
import com.ato.ui_state.base.text.UiSimpleText


@Composable
fun DisplayTwoButtonRow(
    firstTitle: UiSimpleText,
    secondTitle: UiSimpleText,
    onFirstClicked: () -> Unit,
    onSecondClicked: () -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = modifier
    ) {
        Card(
            modifier = Modifier.weight(1f),
            onClick = onFirstClicked
        ) {
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier.fillMaxWidth()
            ) {
                DisplaySingleLineText(
                    firstTitle,
                    modifier = Modifier
                        .padding(8.dp)
                )
            }
        }
        Spacer(Modifier.width(8.dp))
        Card(
            modifier = Modifier.weight(1f),
            onClick = onSecondClicked
        ) {
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier.fillMaxWidth()
            ) {
                DisplaySingleLineText(
                    secondTitle,
                    modifier = Modifier
                        .padding(8.dp)
                )
            }
        }
    }
}