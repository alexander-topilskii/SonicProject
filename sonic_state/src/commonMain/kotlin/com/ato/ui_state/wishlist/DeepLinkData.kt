package com.ato.ui_state.wishlist

import io.ktor.http.Url
import kotlinx.serialization.Serializable

@Serializable
data class DeepLinkData(
    val scheme: String?,
    val host: String?,
    val pathSegments: List<String>,
    val userId: String? = null,
    val wishId: String? = null,
    val wishName: String? = null,
    val wishUrl: String? = null,
    val wishDescription: String? = null,
) {
    companion object {
        const val APP: String = "app"
        const val FRIENDS: String = "friends"
        const val WISHES: String = "wishes"
        const val ADD_WISH: String = "add_wish"
        const val SETTINGS: String = "settings"
        const val EVENTS: String = "events"

        const val PARAM_USER_ID = "userId"
        const val PARAM_WISH_ID = "wishId"
        const val PARAM_WISH_NAME = "wishName"
        const val PARAM_WISH_URL = "wishUrl"
        const val PARAM_WISH_DESCRIPTION = "wishDescription"
        val addWish = DeepLinkData(
            scheme = "wishlist",
            host = "yalito.me",
            pathSegments = listOf("app", "wish", "add_wish"),
            userId = null,
            wishId = null,
            wishUrl = null
        )

        fun fromUrl(urlString: String): DeepLinkData? {

            return if (
                urlString.startsWith("https://yalito.me/app/") ||
                urlString.startsWith("wishlist://yalito.me/app/")
            ) {
                val url = Url(urlString)
                val pathSegments = url.pathSegments.filter { it.isNotEmpty() }
                val userId = url.parameters[PARAM_USER_ID]
                val wishId = url.parameters[PARAM_WISH_ID]
                val wishName = url.parameters[PARAM_WISH_NAME]
                val wishUrl = url.parameters[PARAM_WISH_URL]
                val wishDescription = url.parameters[PARAM_WISH_DESCRIPTION]

                DeepLinkData(
                    scheme = url.protocol.name,
                    host = url.host,
                    pathSegments = pathSegments,
                    userId = userId,
                    wishId = wishId,
                    wishUrl = wishUrl,
                    wishDescription = wishDescription,
                    wishName = wishName
                ).getTail()
            } else {
                addWish.getTail()
            }
        }

        fun getAddWishWithDescription(sharedUris: List<String>): DeepLinkData? {
            return addWish.copy(wishDescription = sharedUris.joinToString { "/n" }).getTail()
        }

        fun getAddWishWithDescription(sharedDescription: String): DeepLinkData? {
            return addWish.copy(wishDescription = sharedDescription).getTail()
        }

        fun getAddWishWithName(name: String): DeepLinkData? {
            return addWish.copy(wishName = name).getTail()
        }

        fun getAddWishWithLink(url: String): DeepLinkData? {
            return addWish.copy(wishUrl = url).getTail()
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
                userId = userId,
                wishId = wishId,
                wishName = wishName,
                wishUrl = wishUrl,
                wishDescription = wishDescription
            )
        } else {
            null
        }
    }
}