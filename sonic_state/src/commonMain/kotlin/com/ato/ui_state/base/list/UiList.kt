package com.ato.ui_state.base.list

import org.jetbrains.compose.resources.StringResource

data class UiList<T>(
    val loading: StringResource,
    val empty: StringResource,
    val contentTitle: StringResource? = null,
    val content: List<T>?
)