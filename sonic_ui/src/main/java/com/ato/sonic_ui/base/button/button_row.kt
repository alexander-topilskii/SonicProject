package com.ato.sonic_ui.base.button

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ato.ui_state.base.button.UiButton
import com.ato.ui_state.base.button.UiButtonsRow


@Composable
fun UiButtonsRow.Display(onClick: (UiButton) -> Unit, modifier: Modifier = Modifier) {
    Row(
        modifier,
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        buttons.forEach {
            it.Display(onClick = { onClick.invoke(it) })
        }
    }
}

@Preview()
@Composable
fun UiButtonsRowPreview() {
    UiButtonsRow(
        buttons = listOf(
            UiButton(
                "clear spaces"
            ),
            UiButton(
                "???"
            )
        )
    )
}