package com.ato.sonic_ui.base.text

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.ato.ui_state.base.text.UiSimpleText
import org.jetbrains.compose.resources.stringResource

@Composable
fun DisplayText(
    state: UiSimpleText,
    modifier: Modifier = Modifier
) {
    Text(
        text = stringResource(state.text),
        modifier = modifier
    )
}