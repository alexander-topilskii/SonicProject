package com.ato.sonic_ui.base.bottom_bar

import androidx.compose.foundation.clickable
import androidx.compose.material3.BottomAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.ato.sonic_ui.base.Display
import com.ato.sonic_ui.base.UiIconItemSamples
import com.ato.ui_state.base.UiBottomBar
import com.ato.ui_state.base.UiIconText
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
fun UiBottomBar.Display(onClick: (UiIconText) -> Unit = {  }) {
    BottomAppBar(
        actions = {
            items.forEach { item: UiIconText ->
                item.Display(
                    modifier = Modifier
                        .weight(1f)
                        .clickable { onClick(item) }
                )
            }
        }
    )
}

@Preview()
@Composable
fun UiBottomBarItem_Empty_Preview() {
    UiBottomBar(
        listOf()
    ).Display()
}

@Preview()
@Composable
fun UiBottomBarItem_One_Preview() {
    UiBottomBar(
        listOf(
            UiIconItemSamples.home
        )
    ).Display()
}

@Preview()
@Composable
fun UiBottomBarItem_Two_Preview() {
    UiBottomBar(
        listOf(
            UiIconItemSamples.menu,
            UiIconItemSamples.edit
        )
    ).Display()
}

@Preview()
@Composable
fun UiBottomBarItem_Five_Preview() {
    UiBottomBar(
        UiIconItemSamples.five_items
    ).Display()
}