package com.ato.ui_state.wishlist

import dev.gitlive.firebase.firestore.Timestamp
import dev.gitlive.firebase.internal.FirebaseDecoder
import dev.gitlive.firebase.internal.FirebaseEncoder
import kotlinx.serialization.KSerializer
import kotlinx.serialization.Serializable
import kotlinx.serialization.Transient
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder

@Serializable
data class WishlistWish(
    @Transient
    var documentId: String? = null,
    var userDocumentId: String? = null,
    @Deprecated("use boardIds")
    var boardDocumentId: String? = "",
    var name: String? = null,
    var description: String? = "",
    var imageUrl: String? = null,
    var creationDate: Timestamp? = null,
    var isCompleted: Boolean? = null,
    var boardIds: List<String>? = null,
    var assignedUserDocumentIds: MutableList<String>? = mutableListOf(),
    var url: String? = null
)

object WishlistWishSerializer : KSerializer<WishlistWish> {
    override val descriptor: SerialDescriptor = WishlistWish.serializer().descriptor

    override fun serialize(encoder: Encoder, value: WishlistWish) {
        // Используем FirebaseEncoder для сериализации
        val firebaseEncoder = FirebaseEncoder(true)
        firebaseEncoder.encodeSerializableValue(WishlistWish.serializer(), value)
    }

    override fun deserialize(decoder: Decoder): WishlistWish {
        // Используем FirebaseDecoder для десериализации
        val firebaseDecoder = FirebaseDecoder(true)
        return firebaseDecoder.decodeSerializableValue(WishlistWish.serializer())
    }
}