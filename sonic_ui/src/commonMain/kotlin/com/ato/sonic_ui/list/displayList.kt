package com.ato.sonic_ui.list

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.ato.ui_state.base.list.UiList
import org.jetbrains.compose.resources.stringResource

fun <T> LazyListScope.displayList(
    uiList: UiList<T>,
    listContent: @Composable (T) -> Unit
) {
    val list = uiList.content
    if (list == null) {
        item {
            Text(
                text = stringResource(uiList.loading),
                modifier = Modifier.padding(
                    horizontal = 16.dp,
                    vertical = 2.dp
                )
            )
        }
    } else {
        if (list.isEmpty()) {
            item {
                Text(
                    text = stringResource(uiList.empty),
                    modifier = Modifier.padding(
                        horizontal = 16.dp,
                        vertical = 2.dp
                    )
                )
            }
        } else {
            items(list) { item ->
                listContent(item)
            }
        }
    }
}