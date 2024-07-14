package com.ato.sonic_ui.base.line

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp


@Composable
fun HorizontalSpaceLine(
    spaceTop: Dp,
    spaceBottom: Dp,
    lineColor: Color,
    line: Dp = 1.dp,
) {
    Spacer(
        modifier = Modifier.height(spaceTop)
    )
    Spacer(
        modifier = Modifier.height(line)
            .padding(horizontal = 4.dp)
            .fillMaxWidth()
            .background(lineColor)
    )
    Spacer(
        modifier = Modifier.height(spaceBottom)
    )
}
