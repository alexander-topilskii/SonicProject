package com.ato.sonic_ui.menu

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ato.ui_state.base.menu.Section
import com.ato.ui_state.base.menu.UiSections
import org.jetbrains.compose.resources.stringResource


@Composable
fun DisplaySections(
    state: UiSections,
    onSelected: (Section) -> Unit,
    modifier: Modifier = Modifier,
) {
    Surface(
        modifier = modifier
            .wrapContentWidth()
            .padding(16.dp),
        shape = RoundedCornerShape(50.dp)
    ) {
        Row(
            modifier = Modifier
                .background(MaterialTheme.colorScheme.primaryContainer)
                .padding(4.dp),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically,
        ) {
            state.items.forEach { item ->
                Text(
                    text = item.title?.let { stringResource(it) } ?: item.name.orEmpty(),
                    modifier = Modifier
                        .background(
                            if (item.isSelected) {
                                MaterialTheme.colorScheme.primary
                            } else {
                                Color.Transparent
                            },
                            shape = RoundedCornerShape(50.dp)
                        )
                        .padding(horizontal = 16.dp, vertical = 4.dp)
                        .clickable { onSelected(item) },
                    color = if (item.isSelected) {
                        MaterialTheme.colorScheme.onPrimary
                    } else {
                        MaterialTheme.colorScheme.onPrimaryContainer
                    },
                    textAlign = TextAlign.Center,
                    fontSize = 18.sp
                )
            }
        }
    }
}