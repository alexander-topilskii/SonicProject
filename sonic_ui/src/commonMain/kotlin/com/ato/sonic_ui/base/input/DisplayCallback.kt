package com.ato.sonic_ui.base.input

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.ato.sonic_ui.base.icons.DisplayIcon
import com.ato.ui_state.base.input.UiEditTextState
import org.jetbrains.compose.resources.stringResource
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.jetbrains.compose.ui.tooling.preview.PreviewParameter

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
                    },
                tint = LocalContentColor.current
            )
        },
        value = textState.value,
        placeholder = if (hint == null) {
            null
        } else {
            hint?.let { { Text(stringResource(it)) } }
        },
        onValueChange = {
            textState.value = it
            onValueChanged(it)
        },
        label = { Text(stringResource(title)) },
        supportingText = { errorText?.let { Text(stringResource(it)) } },
        isError = errorText != null,
        minLines = minLines,
        maxLines = maxLines,
        singleLine = singleLine,
        modifier = modifier,
        keyboardOptions = KeyboardOptions(keyboardType = keyboardType as KeyboardType)
    )
}

@Preview()
@Composable
fun Demo2(
    @PreviewParameter(UiEditTextStateProvider::class)
    item: UiEditTextState
) {
    DisplayEditableText(item)
}