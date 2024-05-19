package com.ato.sonic_ui.base.input

import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.ato.ui_state.base.input.UiEditTextState

@Composable
fun UiEditTextState.Display(modifier: Modifier = Modifier, onValueChanged: (String) -> Unit = {}) {
    OutlinedTextField(
        value = inputText,
        onValueChange = onValueChanged,
        label = { Text(title) },
        minLines = minLines,
        maxLines = maxLines,
        singleLine = singleLine,
        modifier = modifier,
        keyboardOptions = KeyboardOptions(keyboardType = keyboardType)
    )
}

@Preview(showBackground = true)
@Composable
fun Demo() {
    UiEditTextState("title", inputText = "kek").Display()
}