package com.ato.sonic_ui.base.text

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.TextUnit
import com.ato.ui_state.base.text.UiSimpleText
import org.jetbrains.compose.resources.stringResource

@Composable
fun DisplayText(
    state: UiSimpleText,
    fontWeight: FontWeight? = null,
    fontSize: TextUnit = TextUnit.Unspecified,
    modifier: Modifier = Modifier
) {
    val title = if (state.formatArgs == null) {
        stringResource(state.text)
    } else {
        stringResource(state.text, state.formatArgs!!)
    }

    Text(
        text = title,
        fontWeight = fontWeight,
        fontSize = fontSize,
        modifier = modifier
    )
}