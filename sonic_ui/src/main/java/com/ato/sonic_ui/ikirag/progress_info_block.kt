package com.ato.sonic_ui.ikirag

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ato.ui_state.ikirag.CountInfoBlock


@Composable
fun CountInfoBlock.Display(
    modifier: Modifier = Modifier
) {
    Text(
        text = this.text,
        modifier = modifier.padding(4.dp)
    )
}

// ------------------------------------------------------------------------
// ------------------------------------------------------------------------
// ------------------------------------------------------------------------

@Preview(showBackground = true)
@Composable
private fun Preview() {
    CountInfoBlock(
        text = """
            10 элементов
        """.trimIndent()
    ).Display()
}