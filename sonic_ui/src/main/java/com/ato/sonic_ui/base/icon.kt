package com.ato.sonic_ui.base

import androidx.compose.foundation.layout.Box
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.ato.ui_state.base.UiIcon
import com.ato.ui_state.base.UiIconSamples

@Composable
fun UiIcon.Display(
    modifier: Modifier = Modifier,
    selected: Boolean = false,
    tint: Color? = null
) {
    Box(
        modifier = modifier
    ) {
        Icon(
            modifier = Modifier.align(Alignment.Center),
            imageVector = icon,
            contentDescription = null,
            tint = tint ?: if (selected) {
                MaterialTheme.colorScheme.onPrimary
            } else MaterialTheme.colorScheme.onPrimary.copy(
                alpha = 0.6f
            )
        )
    }
}

// ------------------------------------------------------------------------
// ------------------------------------------------------------------------
// ------------------------------------------------------------------------

@Preview(showBackground = true)
@Composable
fun UiIconPreview() {
    UiIconSamples.menu.Display()
}
