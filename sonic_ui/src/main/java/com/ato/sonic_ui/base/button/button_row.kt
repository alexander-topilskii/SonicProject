package com.ato.sonic_ui.base.button

import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.rememberScrollState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.ato.ui_state.base.button.UiButton
import com.ato.ui_state.base.button.UiButtonsRow


@Composable
fun UiButtonsRow.Display(onClick: (UiButton) -> Unit, modifier: Modifier = Modifier) {
    val scroll = rememberScrollState()
    Row(
        modifier.horizontalScroll(scroll),
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