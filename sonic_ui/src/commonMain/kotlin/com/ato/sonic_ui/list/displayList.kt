package com.ato.sonic_ui.list

import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import com.ato.ui_state.base.list.UiList
import org.jetbrains.compose.resources.stringResource

fun <T> LazyListScope.displayList(
    uiList: UiList<T>,
    modifier: Modifier = Modifier,
    listContent: @Composable (T, Modifier) -> Unit,
) {
    val list = uiList.content
    uiList.contentTitle?.let { contentTitle ->
        item {
            Text(
                text = stringResource(contentTitle),
                modifier = modifier,
                fontWeight = FontWeight.SemiBold
            )
        }
    }
    if (list == null) {
        item {
            Text(
                text = stringResource(uiList.loading),
                modifier = modifier
            )
        }
    } else {
        if (list.isEmpty()) {
            item {
                Text(
                    text = stringResource(uiList.empty),
                    modifier = modifier
                )
            }
        } else {
            items(list) { item ->
                listContent(item, modifier)
            }
        }
    }
}