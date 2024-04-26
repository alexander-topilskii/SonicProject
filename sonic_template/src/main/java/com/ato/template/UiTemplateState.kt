package com.ato.template

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

internal data class UiTemplateState(
    val text: String
)

@Preview
@Composable
fun Demo() {
    UiTemplateState(
        text = "Template"
    ).Display()
}

@Composable
internal fun UiTemplateState.Display() {
    Text(text = text)
}
