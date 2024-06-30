package com.ato.sonic_ui.base.input

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.ato.sonic_ui.base.icons.DisplayIcon
import com.ato.ui_state.base.input.UiEditTextState
import org.jetbrains.compose.resources.stringResource
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.jetbrains.compose.ui.tooling.preview.PreviewParameter
import org.jetbrains.compose.ui.tooling.preview.PreviewParameterProvider

@Composable
fun UiEditTextState.Display(
    modifier: Modifier = Modifier,
    onValueChanged: (String) -> Unit = {},
    onEndIconClicked: (() -> Unit)? = null
) {
    OutlinedTextField(
        trailingIcon = {
            DisplayIcon(
                endIcon,
                modifier = Modifier
                    .padding(4.dp)
                    .clickable {
                        onEndIconClicked?.invoke()
                    },
                tint = LocalContentColor.current
            )
        },
        value = inputText,
        onValueChange = onValueChanged,
        label = { Text(stringResource(title)) },
        minLines = minLines,
        maxLines = maxLines,
        singleLine = singleLine,
        modifier = modifier,
        keyboardOptions = KeyboardOptions(keyboardType = keyboardType as KeyboardType)
    )
}

@Preview()
@Composable
fun Demo(
    @PreviewParameter(UiEditTextStateProvider::class)
    item: UiEditTextState
) {
    item.Display()
}

class UiEditTextStateProvider : PreviewParameterProvider<UiEditTextState> {
    override val values = listOf<UiEditTextState>(
//        UiEditTextState(
//            title = "title",
//            inputText = "kek",
//            keyboardType = KeyboardType.Text
//        ),
//        UiEditTextState(
//            title = "",
//            inputText = "kek",
//            keyboardType = KeyboardType.Text
//        ),
//        UiEditTextState(
//            title = "title",
//            inputText = "kek",
//            minLines = 4,
//            keyboardType = KeyboardType.Text
//        ),
//        UiEditTextState(
//            title = "title",
//            inputText = "kek",
//            minLines = 5,
//            endIcon = UiIcon(Icons.Filled.AddCircle),
//            keyboardType = KeyboardType.Text
//        )
    ).asSequence()
}