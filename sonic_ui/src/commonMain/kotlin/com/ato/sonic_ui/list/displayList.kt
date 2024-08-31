package com.ato.sonic_ui.list

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.foundation.lazy.LazyRow
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
    if (!uiList.isVisible) return

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

@Composable
fun <T> DisplayListAsRow(
    uiList: UiList<T>,
    modifier: Modifier = Modifier,
    containerModifier: Modifier= Modifier,
    listContent: @Composable (T, Modifier) -> Unit,
) {
    if (!uiList.isVisible) return

    val list = uiList.content
    Column(containerModifier) {
        uiList.contentTitle?.let { contentTitle ->
                Text(
                    text = stringResource(contentTitle),
                    modifier = modifier,
                    fontWeight = FontWeight.SemiBold
                )
        }
        if (list == null) {
                Text(
                    text = stringResource(uiList.loading),
                    modifier = modifier
                )
        } else {
            if (list.isEmpty()) {
                    Text(
                        text = stringResource(uiList.empty),
                        modifier = modifier
                    )
            } else {
                LazyRow {
                    items(list) { item ->
                        listContent(item, modifier)
                    }
                }
            }
        }
    }
}


