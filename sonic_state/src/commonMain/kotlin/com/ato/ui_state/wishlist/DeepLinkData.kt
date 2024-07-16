package com.ato.ui_state.wishlist

import io.ktor.http.Url

data class DeepLinkData(
    val scheme: String?,
    val host: String?,
    val pathSegments: List<String>,
    val userId: String?,
    val wishId: String?
) {
    companion object {
        const val APP : String = "app"
        const val FRIENDS : String = "friends"
        const val WISHES : String = "wishes"
        const val SETTINGS : String = "settings"
        const val EVENTS : String = "events"

        fun fromUrl(url: Url): DeepLinkData? {
            val pathSegments = url.pathSegments.filter { it.isNotEmpty() }
            val userId = url.parameters["userId"]
            val wishId = url.parameters["wishId"]

            return if (pathSegments.first() == APP) {
                DeepLinkData(
                    scheme = url.protocol.name,
                    host = url.host,
                    pathSegments = pathSegments,
                    userId = userId,
                    wishId = wishId
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
        return if (pathSegments.size > 1) {
            DeepLinkData(
                scheme = scheme,
                host = host,
                pathSegments = pathSegments.drop(1),
                userId = userId,
                wishId = wishId
            )
        } else {
            null
        }
    }
}