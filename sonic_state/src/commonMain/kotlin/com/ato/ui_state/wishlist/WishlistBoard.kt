package com.ato.ui_state.wishlist

import dev.gitlive.firebase.firestore.Timestamp
import kotlinx.serialization.Serializable

@Serializable
data class WishlistBoard(
    var documentId: String? = null,
    var userDocumentId: String? = null,
    var name: String? = null,
    var wishListIds: List<String>? = emptyList(),
    var creationDate: Timestamp? = null,
)