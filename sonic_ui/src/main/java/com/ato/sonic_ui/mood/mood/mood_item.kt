package com.ato.sonic_ui.mood.mood

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.ato.ui_state.mood.UiMoodItem


@Composable
fun UiMoodItem.Display(modifier: Modifier = Modifier) {
    Text(
        text = this.text,
        modifier = modifier
    )
}

// ------------------------------------------------------------------------
// ------------------------------------------------------------------------
// ------------------------------------------------------------------------

@Preview(showBackground = true)
@Composable
private fun Preview() {
    UiMoodItem("Your mood was 3.0").Display()
}
