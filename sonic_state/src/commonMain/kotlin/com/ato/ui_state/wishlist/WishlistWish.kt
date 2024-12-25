package com.ato.ui_state.wishlist

import kotlinx.serialization.Serializable
import kotlinx.serialization.Transient

@Serializable
data class WishlistWish(
    var documentId: String? = null,
    var userDocumentId: String? = null,
    @Deprecated("use boardIds")
    var boardDocumentId: String? = "",
    var name: String? = null,
    var description: String? = "",
    var imageUrl: String? = null,
//    @Serializable(with = TimestampSerializer::class)
//    var creationDate: Timestamp? = null,
    var isCompleted: Boolean? = null,
    var boardIds: List<String>? = null,
    var assignedUserDocumentIds: MutableList<String>? = mutableListOf(),
    var url: String? = null
)