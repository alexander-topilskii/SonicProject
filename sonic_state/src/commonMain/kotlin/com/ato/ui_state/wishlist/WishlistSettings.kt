package com.ato.ui_state.wishlist

import kotlinx.serialization.Serializable
import kotlinx.serialization.Transient

@Serializable
data class WishlistSettings(
    @Transient
    var documentId: String? = null,
    val skipName: Boolean? = null
)