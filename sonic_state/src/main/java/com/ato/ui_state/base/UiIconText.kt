package com.ato.ui_state.base

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Settings
import androidx.compose.ui.graphics.vector.ImageVector

data class UiIconText(
    val icon: ImageVector,
    val text: String? = null
)

 object UiIconItemSamples {
     val menu = UiIconText(
        icon = Icons.Filled.Menu,
        text = "Menu"
    )
     val edit = UiIconText(
        icon = Icons.Filled.Edit,
        text = "Edit"
    )
     val close = UiIconText(
        icon = Icons.Filled.Close,
        text = "Close"
    )
     val settings = UiIconText(
        icon = Icons.Filled.Settings,
        text = "Settings"
    )
     val home = UiIconText(
        icon = Icons.Filled.Home,
        text = "Home"
    )

     val five_items = listOf(
        menu,
        edit,
        close,
        settings,
        home,
    )
}