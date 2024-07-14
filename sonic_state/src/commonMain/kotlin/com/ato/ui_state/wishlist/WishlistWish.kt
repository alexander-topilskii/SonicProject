package com.ato.ui_state.wishlist

import dev.gitlive.firebase.firestore.Timestamp
import kotlinx.serialization.Serializable

@Serializable
data class WishlistWish(
    var documentId: String? = null,
    var userDocumentId: String? = null,
    var boardDocumentId: String? = null,
    var name: String? = null,
    var description: String = "",
    var creationDate: Timestamp? = null,
    var assignedUserDocumentIds: MutableList<String> = mutableListOf(),
    var url: String? = null
)