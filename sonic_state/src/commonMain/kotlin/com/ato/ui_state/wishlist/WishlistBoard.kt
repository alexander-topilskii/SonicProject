package com.ato.ui_state.wishlist

import dev.gitlive.firebase.firestore.Timestamp
import kotlinx.serialization.Serializable
import kotlinx.serialization.Transient

@Serializable
data class WishlistBoard(
    @Transient
    var documentId: String? = null,
    var userDocumentId: String? = null,
    var name: String? = null,
    var wishListIds: List<String>? = emptyList(),
    var availableForFollowing: Boolean? = null,
    var availableForAll: Boolean? = null,
    var availableForUserIds: List<String>? = emptyList(),
    var creationDate: Timestamp? = null,
)