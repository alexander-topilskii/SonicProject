package com.ato.sonic_ui.ikirag

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.ato.ui_state.ikirag.ProgressInfoBlock
import org.jetbrains.compose.resources.stringResource
import org.jetbrains.compose.ui.tooling.preview.Preview


@Composable
fun ProgressInfoBlock.Display(
    modifier: Modifier = Modifier
) {
    Text(
        text = stringResource(text, progress),
        modifier = modifier.padding(4.dp)
    )
}

// ------------------------------------------------------------------------
// ------------------------------------------------------------------------
// ------------------------------------------------------------------------

@Preview()
@Composable
private fun Preview() {
//    ProgressInfoBlock(
//        text = """
//            10 элементов
//        """.trimIndent()
//    ).Display()
}