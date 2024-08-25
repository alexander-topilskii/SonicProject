package com.ato.ui_state.template.deeplink

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
        const val HOST: String = "template.com"
        const val SCHEME: String = "scheme"
        const val HTTPS: String = "https"
        const val SETTINGS: String = "settings"


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
