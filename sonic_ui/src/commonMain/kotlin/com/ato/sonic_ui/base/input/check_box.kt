package com.ato.sonic_ui.base.input

import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.ato.sonic_ui.base.text.DisplayText
import com.ato.ui_state.base.input.UiCheckBox
import org.jetbrains.compose.resources.stringResource
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.jetbrains.compose.ui.tooling.preview.PreviewParameter
import org.jetbrains.compose.ui.tooling.preview.PreviewParameterProvider

@Composable
fun DisplayCheckBox(
    state: UiCheckBox,
    modifier: Modifier = Modifier,
    onValueChanged: (Boolean) -> Unit = {}
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
    ) {
        if (!state.textToCheck) {
            Checkbox(
                checked = state.isChecked,
                onCheckedChange = { onValueChanged.invoke(it) }
            )
        }
        state.description?.let { description ->
            DisplayText(description)
        }
        if (state.textToCheck) {
            Checkbox(
                checked = state.isChecked,
                onCheckedChange = { onValueChanged.invoke(it) }
            )
        }
    }
}

@Composable
@Preview()
fun Demo(
    @PreviewParameter(UiCheckBoxProvider::class)
    item: UiCheckBox,
) {

}

class UiCheckBoxProvider : PreviewParameterProvider<UiCheckBox> {
    override val values = listOf<UiCheckBox>(
//        UiCheckBox(
//            isChecked = true,
//            description = "text1"
//        ),
//        UiCheckBox(
//            isChecked = false,
//            description = "text2",
//            textToCheck = false
//        ),
//        UiCheckBox(
//            isChecked = false,
//            description = null,
//        ),
//        UiCheckBox(
//            isChecked = false,
//            description = "long long long text"
//        ),
    ).asSequence()
}
