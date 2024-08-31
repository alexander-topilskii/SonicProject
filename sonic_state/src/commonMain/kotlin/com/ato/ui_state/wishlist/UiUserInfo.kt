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
    val nameTitle: UiSimpleText, // Name
    val name: UiSimpleText,
    val wishCountTitle: UiSimpleText, // Wish count
    val wishCount: UiSimpleText,
    val completedWishTitle: UiSimpleText, // Completed wishes
    val completedWish: UiSimpleText,
    val takenWishCountTitle: UiSimpleText, // Taken wish count
    val takenWishCount: UiSimpleText,
    val privacyTitle: UiSimpleText,
    val privacy: UiSimpleText
)