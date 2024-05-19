package com.ato.sonic_ui.base.input

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import androidx.compose.ui.unit.dp
import com.ato.sonic_ui.base.Display
import com.ato.ui_state.base.UiIcon
import com.ato.ui_state.base.input.UiEditTextState

@Composable
fun UiEditTextState.Display(
    modifier: Modifier = Modifier,
    onValueChanged: (String) -> Unit = {},
    onEndIconClicked: (() -> Unit)? = null
) {
    OutlinedTextField(
        trailingIcon = {
            endIcon?.Display(
                modifier = Modifier
                    .padding(4.dp)
                    .clickable {
                        onEndIconClicked?.invoke()
                    }
            )
        },
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
fun Demo(
    @PreviewParameter(UiEditTextStateProvider::class)
    item: UiEditTextState
) {
    item.Display()
}

class UiEditTextStateProvider : PreviewParameterProvider<UiEditTextState> {
    override val values = listOf(
        UiEditTextState(
            title = "title",
            inputText = "kek"
        ),
        UiEditTextState(
            title = "",
            inputText = "kek"
        ),
        UiEditTextState(
            title = "title",
            inputText = "kek",
            minLines = 4
        ),
        UiEditTextState(
            title = "title",
            inputText = "kek",
            minLines = 5,
            endIcon = UiIcon(Icons.Filled.AddCircle)
        )
    ).asSequence()
}