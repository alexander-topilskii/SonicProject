package com.ato.sonic_ui.base.bottom_bar

import androidx.compose.foundation.layout.Column
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import com.ato.sonic_ui.base.Display
import com.ato.ui_state.base.NavBarItem
import com.ato.ui_state.base.UiIcon
import com.ato.ui_state.base.UiNavBar

@Composable
fun UiNavBar.Display(onClick: (Int) -> Unit = { }) {
    var selectedTabIndex by rememberSaveable {
        mutableIntStateOf(0)
    }

    NavigationBar {
        items.forEachIndexed { index, (uiIconText, text) ->
            NavigationBarItem(
                selected = false,
                onClick = {
                    selectedTabIndex = index
                    onClick(index)
                },
                icon = {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        uiIconText.Display(selected = selectedTabIndex == index)
                        if (text != null) {
                            Text(
                                text = text,
                                fontWeight = if (selectedTabIndex == index) FontWeight.Bold else FontWeight.Normal
                            )
                        }
                    }
                }
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun UiNavBarItem_Empty_Preview() {
    UiNavBar(
        listOf()
    ).Display()
}

@Preview(showBackground = true)
@Composable
fun MUiBottomBarItem_One_Preview() {
    UiNavBar(
        listOf(
            NavBarItem(UiIcon(Icons.Filled.Home), "Home")
        )
    ).Display()
}

@Preview(showBackground = true)
@Composable
fun MUiBottomBarItem_Two_Preview() {
    UiNavBar(
        listOf(
            NavBarItem(
                icon = UiIcon(Icons.Filled.Home),
                title = "Home"
            ),
            NavBarItem(
                icon = UiIcon(Icons.Filled.Add),
                title = "Add"
            ),
        )
    ).Display()
}


@Preview(showBackground = true)
@Composable
fun MUiBottomBarItem_No_Title_Two_Preview() {
    UiNavBar(
        listOf(
            NavBarItem(
                icon = UiIcon(Icons.Filled.Home),
                title = null
            ),
            NavBarItem(
                icon = UiIcon(Icons.Filled.Add),
                title = "Add"
            ),
        )
    ).Display()
}

@Preview(showBackground = true)
@Composable
fun MUiBottomBarItem_Five_Preview() {
    UiNavBar(
        listOf(
            NavBarItem(
                icon = UiIcon(Icons.Filled.Home),
                title = "Home"
            ),
            NavBarItem(
                icon = UiIcon(Icons.Filled.Add),
                title = "Add"
            ),
            NavBarItem(
                icon = UiIcon(Icons.Filled.Settings),
                title = "Settings"
            ),
            NavBarItem(
                icon = UiIcon(Icons.Filled.Email),
                title = "Email"
            ),
            NavBarItem(
                icon = UiIcon(Icons.Filled.Edit),
                title = "Edit"
            ),
        )
    ).Display()
}