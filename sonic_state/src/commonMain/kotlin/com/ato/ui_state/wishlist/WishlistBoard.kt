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
    var emoji: String? = null,
    @Deprecated("Don't use it. We use it to filter old boards")
    var isDefault: Boolean? = null,
    var wishIds: List<String>? = null,
    var availableForFollowing: Boolean? = null,
    var availableForAll: Boolean? = null,
    var availableForUserIds: List<String>? = null,
    var creationDate: Timestamp? = null,
)


