package com.ato.sonic_ui.base.text

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ato.sonic_ui.base.button.DisplayButton
import com.ato.sonic_ui.base.line.HorizontalSpaceLine
import com.ato.ui_state.base.text.UiTitle
import org.jetbrains.compose.resources.stringResource


@Composable
fun DisplayTitle(
    state: UiTitle,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Spacer(modifier = Modifier.height(16.dp))
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = modifier.fillMaxWidth()
    ) {
        Text(
            text = stringResource(state.title),
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .padding(horizontal = 16.dp),
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
            fontSize = 36.sp,
        )

        state.button?.let {
            DisplayButton(
                state = it,
                onClick = onClick,
                modifier = Modifier
                    .padding(horizontal = 16.dp)
            )
        }
    }
    HorizontalSpaceLine(
        spaceTop = 8.dp,
        line = 1.dp,
        lineColor = MaterialTheme.colorScheme.primary,
        spaceBottom = 16.dp
    )
}
