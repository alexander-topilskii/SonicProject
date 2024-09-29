package com.ato.ui_state.wishlist.deeplink

import io.ktor.http.Url
import kotlinx.serialization.Serializable

@Serializable
data class DeepLinkData(
    val scheme: String?,
    val host: String?,
    val pathSegments: List<String>,
    val deeplinkParams: DeeplinkParams
) {
    companion object {
        const val APP: String = "app"
        const val HOST: String = "yalito.me"
        const val SCHEME: String = "wishlist"
        const val HTTPS: String = "https"
        const val FRIENDS: String = "friends"
        const val WISHES: String = "wishes"
        const val ADD_WISH: String = "add_wish"
        const val SETTINGS: String = "settings"
        const val EVENTS: String = "events"


        fun fromUrl(urlString: String): DeepLinkData? {
            return if (
                urlString.startsWith("$HTTPS://$HOST/$APP/") ||
                urlString.startsWith("$SCHEME://$HOST/$APP/")
            ) {
                val url = Url(urlString)
                val pathSegments = url.pathSegments.filter { it.isNotEmpty() }

                DeepLinkData(
                    scheme = url.protocol.name,
                    host = url.host,
                    pathSegments = pathSegments,
                    deeplinkParams = DeeplinkParams.fromUrl(url)
                ).getTail()
            } else {
                // Если это не наша схема, то юзер хочет добавить наше желание
                DeeplinkCreator.addWishDeeplink.getTail()
            }
        }

        fun getAddWishWithDescription(sharedUris: List<String>): DeepLinkData? {
            val addWish = DeeplinkCreator.addWishDeeplink
            return addWish.copy(
                deeplinkParams = addWish.deeplinkParams.copy(
                    wishDescription = sharedUris.joinToString { "/n" }
                )
            ).getTail()
        }

        fun getAddWishWithDescription(sharedDescription: String): DeepLinkData? {
            val addWish = DeeplinkCreator.addWishDeeplink
            return addWish.copy(
                deeplinkParams = addWish.deeplinkParams.copy(
                    wishDescription = sharedDescription
                )
            ).getTail()
        }

        fun getAddWishWithName(name: String): DeepLinkData? {
            val addWish = DeeplinkCreator.addWishDeeplink
            return addWish.copy(
                deeplinkParams = addWish.deeplinkParams.copy(
                    wishName = name
                )
            ).getTail()
        }

        fun getAddWishWithLink(url: String): DeepLinkData? {
            val addWish = DeeplinkCreator.addWishDeeplink
            return addWish.copy(
                deeplinkParams = addWish.deeplinkParams.copy(
                    wishUrl = url
                )
            ).getTail()
        }
    }

    fun getHead(): String? {
        return if (pathSegments.isNotEmpty()) pathSegments.first() else null
    }

    fun getTail(): DeepLinkData? {
        return if (pathSegments.isNotEmpty()) {
            DeepLinkData(
                scheme = scheme,
                host = host,
                pathSegments = pathSegments.drop(1),
                deeplinkParams = deeplinkParams
            )
        } else {
            null
        }
    }

    fun toDeeplink(): String {
        val path = pathSegments.joinToString(separator = "/")
        val query = deeplinkParams.toQueryString()

        return "$scheme://$host/$path?$query"
    }
}

interface DeeplinkExecutor {
    fun openDeeplink(deepLinkData: DeepLinkData)
}
