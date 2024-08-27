import dev.gitlive.firebase.firestore.Timestamp
import dev.gitlive.firebase.internal.FirebaseDecoder
import dev.gitlive.firebase.internal.FirebaseEncoder
import kotlinx.serialization.KSerializer
import kotlinx.serialization.Serializable
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonElement

// Создаем кастомный сериализатор для WishlistWish
object WishlistWishSerializer : KSerializer<Wish> {
    override val descriptor: SerialDescriptor = Wish.serializer().descriptor

    override fun serialize(encoder: Encoder, value: Wish) {
        // Используем FirebaseEncoder для сериализации
        val firebaseEncoder = FirebaseEncoder(true)
        firebaseEncoder.encodeSerializableValue(Wish.serializer(), value)
    }

    override fun deserialize(decoder: Decoder): Wish {
        // Используем FirebaseDecoder для десериализации
        val firebaseDecoder = FirebaseDecoder(true)
        return firebaseDecoder.decodeSerializableValue(Wish.serializer())
    }
}

fun main() {
    // Создаем пример объекта WishlistWish
    val originalWish = Wish(
        documentId = "doc123",
        creationDate = Timestamp.now()
    )

    // Сериализация объекта в строку JSON
    val json = Json { prettyPrint = true }
    val serializedWish: String = json.encodeToString(WishlistWishSerializer, originalWish)

    // Выводим сериализованную строку
    println("Serialized WishlistWish: \n$serializedWish")

    // Десериализация объекта из строки JSON
    val deserializedWish: Wish = json.decodeFromString(WishlistWishSerializer, serializedWish)
    // Выводим десериализованный объект
    println("Deserialized Wish: \n$deserializedWish")
}

@Serializable
data class Wish(
    var documentId: String? = null,
    var creationDate: Timestamp? = null,
)