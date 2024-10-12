package com.ato.ui_state.wishlist

import dev.gitlive.firebase.firestore.Timestamp
import kotlinx.serialization.InternalSerializationApi
import kotlinx.serialization.KSerializer
import kotlinx.serialization.Serializable
import kotlinx.serialization.SerializationException
import kotlinx.serialization.Transient
import kotlinx.serialization.descriptors.PolymorphicKind
import kotlinx.serialization.descriptors.PrimitiveKind
import kotlinx.serialization.descriptors.PrimitiveSerialDescriptor
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.descriptors.buildSerialDescriptor
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

object JsonTimestampSerializer : KSerializer<Timestamp?> {
    @OptIn(InternalSerializationApi::class)
    override val descriptor: SerialDescriptor = buildSerialDescriptor("Timestamp", PolymorphicKind.OPEN)

    override fun serialize(encoder: Encoder, value: Timestamp?) {
        if (value == null) {
            encoder.encodeNull()
        } else {
            // You can choose which format to serialize into
            // For simplicity, serialize as nested object
            val compositeEncoder = encoder.beginStructure(descriptor)
            compositeEncoder.encodeLongElement(descriptor, 0, value.seconds)
            compositeEncoder.encodeIntElement(descriptor, 1, value.nanoseconds)
            compositeEncoder.endStructure(descriptor)
        }
    }

    override fun deserialize(decoder: Decoder): Timestamp? {
        if (decoder.decodeNotNullMark()) {
            return try {
                // Try decoding as a nested object
                val compositeDecoder = decoder.beginStructure(descriptor)
                var seconds: Long? = null
                var nanoseconds: Int? = null

                loop@ while (true) {
                    when (val index = compositeDecoder.decodeElementIndex(descriptor)) {
                        0 -> seconds = compositeDecoder.decodeLongElement(descriptor, 0)
                        1 -> nanoseconds = compositeDecoder.decodeIntElement(descriptor, 1)
                        CompositeDecoder.DECODE_DONE -> break@loop
                        else -> throw SerializationException("Unknown index $index")
                    }
                }
                compositeDecoder.endStructure(descriptor)

                if (seconds != null && nanoseconds != null) {
                    Timestamp(seconds, nanoseconds)
                } else {
                    null
                }
            } catch (e: SerializationException) {
                // If decoding as object fails, try decoding as Long
                val milliseconds = decoder.decodeLong()
                val seconds = milliseconds / 1000L
                val nanoseconds = ((milliseconds % 1000L) * 1_000_000L).toInt()
                Timestamp(seconds, nanoseconds)
            }
        } else {
            decoder.decodeNull()
            return null
        }
    }
}


