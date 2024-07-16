package com.ato.ui_state.wishlist

import io.ktor.http.Url
import kotlinx.serialization.Serializable

@Serializable
data class DeepLinkData(
    val scheme: String?,
    val host: String?,
    val pathSegments: List<String>,
    val userId: String?,
    val wishId: String?,
    val wishName: String?,
    val wishUrl: String?,
    val wishDescription: String?,
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

        fun fromUrl(url: Url): DeepLinkData? {
            val pathSegments = url.pathSegments.filter { it.isNotEmpty() }
            val userId = url.parameters[PARAM_USER_ID]
            val wishId = url.parameters[PARAM_WISH_ID]

            val wishName = url.parameters[PARAM_WISH_NAME]
            val wishUrl = url.parameters[PARAM_WISH_URL]
            val wishDescription = url.parameters[PARAM_WISH_DESCRIPTION]

            return if (pathSegments.first() == APP) {
                DeepLinkData(
                    scheme = url.protocol.name,
                    host = url.host,
                    pathSegments = pathSegments,
                    userId = userId,
                    wishId = wishId,
                    wishName = wishName,
                    wishUrl = wishUrl,
                    wishDescription = wishDescription
                ).getTail()
            } else {
                null
            }
        }
    }

    fun getPathSegment(index: Int): String? {
        return if (index in pathSegments.indices) pathSegments[index] else null
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