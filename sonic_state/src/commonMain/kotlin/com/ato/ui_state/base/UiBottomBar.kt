package com.ato.ui_state.base

data class UiBottomBar(
    val items: List<UiIconText>
)

data class UiNavBar(
    val items: List<NavBarItem>
)

data class NavBarItem(
    val icon: UiIcon,
    val title: String? = null,
    val isSelected: Boolean = false,
    val reset: Boolean = false,
    val meta: Any? = null
)


