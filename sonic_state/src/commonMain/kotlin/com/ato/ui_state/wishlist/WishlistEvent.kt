package com.ato.ui_state.wishlist

import dev.gitlive.firebase.firestore.Timestamp
import dev.gitlive.firebase.firestore.TimestampSerializer
import kotlinx.serialization.Serializable
import kotlinx.serialization.Transient

@Serializable
data class WishlistEvent(
    @Transient
    var documentId: String? = null,
    var userDocumentId: String? = null,
    var name: String? = null,
    var description: String? = null,
    var isAnnual: Boolean? = null,
    @Serializable(with = CustomTimestampSerializer::class)
    var eventDate: Timestamp? = null,
    @Serializable(with = CustomTimestampSerializer::class)
    var creationDate: Timestamp? = null,
)