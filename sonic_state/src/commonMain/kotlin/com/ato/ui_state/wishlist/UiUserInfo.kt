package com.ato.ui_state.wishlist

import org.jetbrains.compose.resources.StringResource

data class UiUserInfo(
    val nameTitle: StringResource, // Name
    val name: String?,
    val nickTitle: StringResource, // Nick
    val nick: String?,
    val emailTitle: StringResource? = null, // Email
    val email: String? = null,
)