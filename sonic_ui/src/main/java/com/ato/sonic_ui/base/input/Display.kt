package com.ato.sonic_ui.base.input

import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.ato.ui_state.base.input.UiAddTextState

@Composable
fun UiAddTextState.Display(modifier: Modifier, onValueChanged: (String) -> Unit) {
    OutlinedTextField(
        value = inputText,
        onValueChange = onValueChanged,
        label = { Text(title) },
        modifier = modifier
    )
}
