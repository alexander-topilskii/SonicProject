package com.ato.sonic_ui.base.button

import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.ato.ui_state.base.button.UiButton


@Composable
fun UiButton.Display(onClick: () -> Unit, modifier: Modifier = Modifier) {
    Button(
        modifier = modifier,
        onClick = onClick
    ) {
        Text(text = title)
    }
}

@Preview()
@Composable
fun ButtonPreview() {
    UiButton("Text").Display({})
}
