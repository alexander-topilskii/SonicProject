package com.ato.ui_state.wishlist

import kotlinx.serialization.Serializable
import kotlinx.serialization.Transient

@Serializable
data class WishlistToggle(
    @Transient
    var documentId: String? = null,
    val skipName: Boolean? = null,
    val niceBoardList: Boolean? = null
)