package com.ato.ui_state.base.grid

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp


@Composable
fun <T1, T2> DisplayGridInfo(
    info: List<Pair<T1, T2>>,
    leftTableContent: @Composable RowScope.(T1, Int, Modifier) -> Unit,
    rightTableContent: @Composable RowScope.(T2, Int, Modifier) -> Unit,
    header: @Composable () -> Unit = {},
    footer: @Composable () -> Unit = {},
    modifier: Modifier = Modifier,
    weights: Pair<Float, Float> = 1f to 2f,
) {
    Box(
        modifier = modifier,
        contentAlignment = Alignment.Center
    ) {
        Card(
            border = BorderStroke(1.dp, MaterialTheme.colorScheme.outline.copy(alpha = 0.1f)),
            modifier = Modifier,
        ) {
            Column(
                modifier = Modifier.fillMaxWidth()
            ) {
                header()
                info.forEachIndexed { index, item ->
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 8.dp, horizontal = 16.dp)
                    ) {
                        leftTableContent(item.first, index, Modifier.weight(weights.first))
                        Spacer(Modifier.width(4.dp))
                        rightTableContent(item.second, index, Modifier.weight(weights.second))
                    }
                }
                footer()
            }
        }
    }
}