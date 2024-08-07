package com.ato.sonic_ui.list

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.BasicText
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ato.sonic_ui.base.icons.DisplayIcon
import com.ato.ui_state.base.UiIcon
import com.ato.ui_state.base.list.UiList
import com.ato.ui_state.base.list.UiMap
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

