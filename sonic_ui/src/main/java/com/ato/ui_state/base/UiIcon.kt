package com.ato.ui_state.base

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Settings
import androidx.compose.ui.graphics.vector.ImageVector

data class UiIcon(
    val icon: ImageVector,
    val contentDescription: String
)


object UiIconSamples {
    val menu = UiIcon(
        icon = Icons.Filled.Menu,
        contentDescription = "Menu"
    )
    val edit = UiIcon(
        icon = Icons.Filled.Edit,
        contentDescription = "Edit"
    )
    val close = UiIcon(
        icon = Icons.Filled.Close,
        contentDescription = "Close"
    )
    val settings = UiIcon(
        icon = Icons.Filled.Settings,
        contentDescription = "Settings"
    )
    val home = UiIcon(
        icon = Icons.Filled.Home,
        contentDescription = "Home"
    )
    val profile = UiIcon(
        icon = Icons.Filled.AccountCircle,
        contentDescription = "Home"
    )

    val five_items = listOf(
        menu,
        edit,
        close,
        settings,
        home,
    )
}