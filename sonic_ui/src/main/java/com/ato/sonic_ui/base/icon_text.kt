package com.ato.sonic_ui.base

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ato.ui_state.base.UiIconText
import com.ato.ui_state.base.UiIconItemSamples

@Composable
fun UiIconText.Display(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .height(80.dp),
        verticalArrangement = Arrangement.Center,
    ) {
        Icon(
            modifier = Modifier.align(
                alignment = Alignment.CenterHorizontally
            ),
            imageVector = icon,
            contentDescription = text
        )
        Text(
            modifier = Modifier.align(
                alignment = Alignment.CenterHorizontally
            ),
            text = text
        )
    }
}

@Preview(showBackground = true)
@Composable
fun Preview() {
    UiIconItemSamples.menu.Display()
}
