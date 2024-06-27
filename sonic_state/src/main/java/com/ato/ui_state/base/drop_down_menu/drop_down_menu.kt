package com.ato.ui_state.base.drop_down_menu


data class UiDropDownMenu(
    val items: List<String> = listOf("Not implemented"),
)

object UiDropDownMenuSamples{
    val item = UiDropDownMenu(
        listOf("Сегодня", "вчера")
    )
}