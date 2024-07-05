package com.ato.sonic_ui.base.text

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import com.ato.ui_state.base.text.UiSimpleText
import org.jetbrains.compose.resources.stringResource

@Composable
fun DisplayText(
    state: UiSimpleText
) {
    Text(text = stringResource(state.text))
}