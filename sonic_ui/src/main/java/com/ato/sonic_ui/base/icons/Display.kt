package com.ato.sonic_ui.base.icons

import androidx.compose.foundation.layout.Box
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.ato.ui_state.base.UiIcon

@Composable
fun DisplayIcon(state: UiIcon?, modifier: Modifier = Modifier, selected: Boolean = false) =
    with(state) {
        if (this == null) {

        } else {
            Box(
                modifier = modifier
            ) {
                if (isLoading) {
                    CircularProgressIndicator(
                        modifier = Modifier.align(Alignment.Center)
                    )
                } else {
                    Icon(
                        modifier = Modifier.align(Alignment.Center),
                        imageVector = icon,
                        contentDescription = null,
                        tint = if (selected) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.secondary
                    )
                }
            }
        }
    }