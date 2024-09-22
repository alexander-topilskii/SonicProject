package com.ato.ui_state.wishlist

import com.ato.ui_state.base.text.UiSimpleText

data class UiCommonInfo(
    val info: List<Pair<UiSimpleText, UiSimpleText>>,
)

data class UiBoardInfo(
    val emoji: String?,
    val info: List<Pair<UiSimpleText, UiSimpleText>>,
)