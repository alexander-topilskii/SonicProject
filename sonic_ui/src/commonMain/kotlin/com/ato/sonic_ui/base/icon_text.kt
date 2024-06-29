package com.ato.sonic_ui.base

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import com.ato.ui_state.base.UiIconText
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
fun UiIconText.Display(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .height(80.dp),
        verticalArrangement = Arrangement.Center,
    ) {
        Icon(
            modifier = Modifier.align(
                alignment = Alignment.CenterHorizontally
            ),
            imageVector = icon as ImageVector,
            contentDescription = text
        )
        text?.let {
            Text(
                modifier = Modifier.align(
                    alignment = Alignment.CenterHorizontally
                ),
                text = text!!
            )
        }
    }
}

// ------------------------------------------------------------------------
// ------------------------------------------------------------------------
// ------------------------------------------------------------------------

@Preview()
@Composable
fun Preview() {
    UiIconItemSamples.menu.Display()
}


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