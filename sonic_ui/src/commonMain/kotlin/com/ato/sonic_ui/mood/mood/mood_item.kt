package com.ato.sonic_ui.mood.mood

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.ato.ui_state.mood.UiMoodItem
import org.jetbrains.compose.ui.tooling.preview.Preview


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

@Preview()
@Composable
private fun Preview() {
    UiMoodItem("Your mood was 3.0").Display()
}
