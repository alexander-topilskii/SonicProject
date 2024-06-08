package com.ato.sonic_ui.base.button

import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import androidx.compose.ui.unit.dp
import com.ato.ui_state.base.button.UiButton

@Composable
fun UiButton.Display(
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Button(
        modifier = modifier,
        onClick = onClick,
        enabled = isEnabled
    ) {
        if (isLoading) {
            CircularProgressIndicator(
                modifier = Modifier.size(ButtonDefaults.IconSize),
                strokeWidth = 2.dp
            )
        } else {
            Text(text = title)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ButtonPreview(
    @PreviewParameter(UiButtonProvider::class) param: UiButton
) {
    param.Display({})
}

class UiButtonProvider : PreviewParameterProvider<UiButton> {
    override val values = listOf(
        UiButton("Text"),
        UiButton("Text", isLoading = true),
        UiButton("Text", isEnabled = false),
        UiButton("Text", isLoading = true, isEnabled = false),
    ).asSequence()
}
