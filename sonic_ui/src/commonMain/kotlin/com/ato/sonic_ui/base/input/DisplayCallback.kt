package com.ato.sonic_ui.base.input

import androidx.compose.foundation.clickable
import androidx.compose.foundation.indication
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.material3.Icon
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import com.ato.sonic_ui.base.icons.DisplayIcon
import com.ato.ui_state.base.input.UiEditTextState
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.jetbrains.compose.ui.tooling.preview.PreviewParameter
import wishlist.sonic_ui.generated.resources.Res
import wishlist.sonic_ui.generated.resources.person_wishes_list_title
import wishlist.sonic_ui.generated.resources.visibility
import wishlist.sonic_ui.generated.resources.visibility_off

@Composable
fun DisplayEditableText(
    state: UiEditTextState,
    modifier: Modifier = Modifier,
    onValueChanged: (String) -> Unit = {},
    onEndIconClicked: (() -> Unit)? = null
) = with(state) {
    val textState = remember(inputText) { mutableStateOf(inputText) }

    OutlinedTextField(
        enabled = isEnabled,
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
        supportingText = {
            errorText?.let {
                Text(stringResource(it))
            } ?: supportText?.let {
                Text(stringResource(it))
            }
        },
        isError = errorText != null,
        minLines = minLines,
        maxLines = maxLines,
        singleLine = singleLine,
        modifier = modifier,
        keyboardOptions = ((keyboardOptions as? KeyboardOptions) ?: KeyboardOptions.Default)
            .copy(keyboardType = keyboardType as KeyboardType)
    )
}

@Composable
fun DisplayEditablePassword(
    state: UiEditTextState,
    modifier: Modifier = Modifier,
    onValueChanged: (String) -> Unit = {},
    onDone: () -> Unit
) = with(state) {
    val textState = remember(inputText) { mutableStateOf(inputText) }
    var passwordVisibility by remember { mutableStateOf(false) }

    OutlinedTextField(
        enabled = isEnabled,
        trailingIcon = {
            Icon(
                modifier = Modifier
                    .size(36.dp)
                    .clip(CircleShape)
                    .clickable(
                        onClick = { passwordVisibility = !passwordVisibility },
                    )
                    .padding(8.dp),
                painter = painterResource(
                    if (passwordVisibility) {
                        Res.drawable.visibility
                    } else {
                        Res.drawable.visibility_off
                    }
                ),
                contentDescription = ""
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
        supportingText = {
            errorText?.let {
                Text(stringResource(it))
            } ?: supportText?.let {
                Text(stringResource(it))
            }
        },
        visualTransformation = if (passwordVisibility) {
            VisualTransformation.None
        } else {
            PasswordVisualTransformation()
        },
        isError = errorText != null,
        minLines = minLines,
        maxLines = maxLines,
        singleLine = singleLine,
        modifier = modifier,
        keyboardOptions = ((keyboardOptions as? KeyboardOptions) ?: KeyboardOptions.Default)
            .copy(keyboardType = keyboardType as KeyboardType),
        keyboardActions = KeyboardActions(
            onDone = {
                println("GGGG::DisplayEditablePassword:done")
                onDone.invoke() },
            onGo = { println("GGGG::DisplayEditablePassword:go")},
            onSend = { println("GGGG::DisplayEditablePassword:se")}
        )
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