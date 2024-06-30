package com.ato.sonic_ui.base.button

import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.ato.ui_state.base.button.UiButton
import com.ato.ui_state.base.button.UiButtonsRow
import org.jetbrains.compose.ui.tooling.preview.Preview


@Composable
fun UiButtonsRow.Display(onClick: (UiButton) -> Unit, modifier: Modifier = Modifier) {
    val scroll = rememberScrollState()
    Row(
        modifier.horizontalScroll(scroll),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        Spacer(modifier = Modifier.width(16.dp))
        buttons.forEach {
            it.Display(onClick = { onClick.invoke(it) })
            Spacer(modifier = Modifier.width(4.dp))
        }
        Spacer(modifier = Modifier.width(16.dp))
    }
}

@Preview()
@Composable
fun UiButtonsRowPreview() {
    UiButtonsRow(
        buttons = listOf<UiButton>(
//            UiButton(
//                "clear spaces"
//            ),
//            UiButton(
//                "???"
//            )
        )
    )
}