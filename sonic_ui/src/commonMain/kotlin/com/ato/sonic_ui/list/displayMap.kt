package com.ato.sonic_ui.list

import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import com.ato.ui_state.base.list.UiMap
import org.jetbrains.compose.resources.stringResource


fun <T1, T2> LazyListScope.displayMap(
    uiList: UiMap<T1, T2>,
    modifier: Modifier = Modifier,
    header: @Composable (Int, T1, Modifier) -> Unit,
    listContent: @Composable (T2?, Modifier) -> Unit,
) {
    if (!uiList.isVisible) return

    val map = uiList.content
    uiList.contentTitle?.let { contentTitle ->
        item {
            Text(
                text = stringResource(contentTitle),
                modifier = modifier,
                fontWeight = FontWeight.SemiBold
            )
        }
    }
    if (map == null) {
        item {
            Text(
                text = stringResource(uiList.loading),
                modifier = modifier
            )
        }
    } else {
        if (map.isEmpty()) {
            item {
                Text(
                    text = stringResource(uiList.empty),
                    modifier = modifier
                )
            }
        } else {
            map.onEachIndexed { index, (headers, dataList) ->
                item {
                    header(index, headers, modifier)
                }
                items(dataList) { item ->
                    listContent(item, modifier)
                }
            }
        }
    }
}