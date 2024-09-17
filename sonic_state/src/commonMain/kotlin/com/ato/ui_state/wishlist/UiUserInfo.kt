package com.ato.ui_state.wishlist

import com.ato.ui_state.base.text.UiSimpleText
import org.jetbrains.compose.resources.StringResource

data class UiUserInfo(
    val nameTitle: StringResource, // Name
    val name: String?,
    val nickTitle: StringResource, // Nick
    val nick: String?,
    val emailTitle: StringResource? = null, // Email
    val email: String? = null,
)

data class UiBoardInfo(
    val emoji: String?,
    val info: List<Pair<UiSimpleText, UiSimpleText>>,
)