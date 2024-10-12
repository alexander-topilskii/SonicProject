package com.ato.ui_state.wishlist

import dev.gitlive.firebase.firestore.Timestamp
import dev.gitlive.firebase.firestore.TimestampSerializer
import kotlinx.serialization.KSerializer
import kotlinx.serialization.Serializable
import kotlinx.serialization.SerializationException
import kotlinx.serialization.Transient
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.descriptors.buildClassSerialDescriptor
import kotlinx.serialization.descriptors.element
import kotlinx.serialization.encoding.CompositeDecoder
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder

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
    @Serializable(with = JsonTimestampSerializer::class)
    var creationDate: Timestamp? = null,
)

object JsonTimestampSerializer : KSerializer<Timestamp> {
    override val descriptor: SerialDescriptor = buildClassSerialDescriptor("Timestamp") {
        element<Long>("seconds")
        element<Int>("nanoseconds")
    }

    override fun serialize(encoder: Encoder, value: Timestamp) {
        val compositeEncoder = encoder.beginStructure(descriptor)
        compositeEncoder.encodeLongElement(descriptor, 0, value.seconds)
        compositeEncoder.encodeIntElement(descriptor, 1, value.nanoseconds)
        compositeEncoder.endStructure(descriptor)
    }

    override fun deserialize(decoder: Decoder): Timestamp {
        val compositeDecoder = decoder.beginStructure(descriptor)
        var seconds: Long = 0L
        var nanoseconds: Int = 0
        loop@ while (true) {
            when (val index = compositeDecoder.decodeElementIndex(descriptor)) {
                0 -> seconds = compositeDecoder.decodeLongElement(descriptor, 0)
                1 -> nanoseconds = compositeDecoder.decodeIntElement(descriptor, 1)
                CompositeDecoder.DECODE_DONE -> break@loop
                else -> throw SerializationException("Unknown index $index")
            }
        }
        compositeDecoder.endStructure(descriptor)
        return Timestamp(seconds, nanoseconds)
    }
}


