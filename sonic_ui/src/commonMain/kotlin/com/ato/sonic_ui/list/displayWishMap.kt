package com.ato.sonic_ui.list

import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ato.sonic_ui.base.icons.DisplayIcon
import com.ato.ui_state.base.UiIcon
import com.ato.ui_state.base.list.UiMap
import org.jetbrains.compose.resources.stringResource


fun <T1, T2> LazyListScope.displayWishMap(
    uiMap: UiMap<T1, T2>,
    modifier: Modifier = Modifier,
    onTitleClicked: (() -> Unit)?,
    header: @Composable (T1, Modifier) -> Unit,
    listContent: @Composable (T2) -> Unit,
) {
    val map = uiMap.content

    uiMap.contentTitle?.let { contentTitle ->
        item {
            Row(
                modifier = modifier
                    .let {
                        if (onTitleClicked != null) {
                            it.clickable(
                                indication = null,
                                interactionSource = remember { MutableInteractionSource() },
                                onClick = onTitleClicked
                            )
                        } else {
                            it
                        }
                    }
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = stringResource(contentTitle),
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 24.sp
                )
                uiMap.contentIcon?.icon?.let { icon ->
                    DisplayIcon(
                        UiIcon(
                            icon = icon,
                        ),
                        modifier = Modifier
                            .size(36.dp)
                            .clip(CircleShape)
                            .padding(8.dp),
                        tint = MaterialTheme.colorScheme.onBackground
                    )
                }
            }
        }
    }
    if (map == null) {
        item {
            Text(
                text = stringResource(uiMap.loading),
                modifier = modifier
            )
        }
    } else {
        if (map.isEmpty()) {
            item {
                Text(
                    text = stringResource(uiMap.empty),
                    modifier = modifier
                )
            }
        } else {
            map.forEach { (headers, dataList) ->
                item {
                    header(headers, modifier)
                }
                item {
                    LazyRow {
                        item { Spacer(Modifier.width(8.dp)) }
                        items(dataList) { item ->
                            listContent(item)
                        }
                        item { Spacer(Modifier.width(8.dp)) }
                    }
                }
            }
        }
    }
}