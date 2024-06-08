package com.ato.sonic_ui.base.input

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.dp
import com.ato.sonic_ui.base.icons.DisplayIcon
import com.ato.ui_state.base.input.UiEditTextState

@Composable
fun DisplayEditableText(
    state: UiEditTextState,
    modifier: Modifier = Modifier,
    onValueChanged: (String) -> Unit = {},
    onEndIconClicked: (() -> Unit)? = null
) = with(state) {
    val textState = remember(inputText) { mutableStateOf(inputText) }
    OutlinedTextField(
        trailingIcon = {
            DisplayIcon(
                state = endIcon,
                modifier = Modifier
                    .padding(4.dp)
                    .clickable {
                        onEndIconClicked?.invoke()
                    })
        },
        value = textState.value,
        onValueChange = {
            textState.value = it
            onValueChanged(it)
        },
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
fun Demo2(
    @PreviewParameter(UiEditTextStateProvider::class)
    item: UiEditTextState
) {
    DisplayEditableText(item)
}