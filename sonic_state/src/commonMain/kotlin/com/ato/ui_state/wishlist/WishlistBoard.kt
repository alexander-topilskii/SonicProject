package com.ato.ui_state.wishlist

import dev.gitlive.firebase.firestore.Timestamp
import dev.gitlive.firebase.firestore.TimestampSerializer
import kotlinx.serialization.InternalSerializationApi
import kotlinx.serialization.KSerializer
import kotlinx.serialization.Serializable
import kotlinx.serialization.SerializationException
import kotlinx.serialization.Transient
import kotlinx.serialization.descriptors.PolymorphicKind
import kotlinx.serialization.descriptors.PrimitiveKind
import kotlinx.serialization.descriptors.PrimitiveSerialDescriptor
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.descriptors.StructureKind
import kotlinx.serialization.descriptors.buildClassSerialDescriptor
import kotlinx.serialization.descriptors.buildSerialDescriptor
import kotlinx.serialization.descriptors.element
import kotlinx.serialization.encoding.CompositeDecoder
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder
import kotlinx.serialization.json.JsonObject
import kotlinx.serialization.json.JsonPrimitive
import kotlinx.serialization.json.int
import kotlinx.serialization.json.jsonObject
import kotlinx.serialization.json.jsonPrimitive
import kotlinx.serialization.json.long

@Serializable
data class WishlistBoard(
    @Transient
    var documentId: String? = null,
    var userDocumentId: String? = null,
    var name: String? = null,
    var emoji: String? = null,
    var backgroundUrl: String? = null,
    @Deprecated("Don't use it. We use it to filter old boards")
    var isDefault: Boolean? = null,
    var wishIds: List<String>? = null,
    var availableForFollowing: Boolean? = null,
    var availableForAll: Boolean? = null,
    var availableForUserIds: List<String>? = null,
//    @Serializable(with = TimestampSerializer::class)
//    var creationDate: Timestamp? = null,
)
object CustomTimestampSerializer : KSerializer<Timestamp> {
    override val descriptor: SerialDescriptor = PrimitiveSerialDescriptor("Timestamp", PrimitiveKind.STRING)

    override fun serialize(encoder: Encoder, value: Timestamp) {
        val jsonEncoder = encoder as? kotlinx.serialization.json.JsonEncoder
            ?: throw SerializationException("This class can be saved only by Json")
        val jsonObject = JsonObject(mapOf(
            "seconds" to JsonPrimitive(value.seconds),
            "nanoseconds" to JsonPrimitive(value.nanoseconds)
        ))
        jsonEncoder.encodeJsonElement(jsonObject)
    }

    override fun deserialize(decoder: Decoder): Timestamp {
        val jsonDecoder = decoder as? kotlinx.serialization.json.JsonDecoder
            ?: throw SerializationException("This class can be loaded only by Json")
        val jsonObject = jsonDecoder.decodeJsonElement().jsonObject
        val seconds = jsonObject["seconds"]?.jsonPrimitive?.long
            ?: throw SerializationException("Missing 'seconds' field")
        val nanoseconds = jsonObject["nanoseconds"]?.jsonPrimitive?.int
            ?: throw SerializationException("Missing 'nanoseconds' field")
        return Timestamp(seconds, nanoseconds)
    }
}

