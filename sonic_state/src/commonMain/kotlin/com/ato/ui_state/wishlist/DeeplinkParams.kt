package com.ato.ui_state.wishlist

import io.ktor.http.Url
import kotlinx.serialization.Serializable

@Serializable
data class DeeplinkParams(
    val userId: String? = null,
    val wishId: String? = null,
    val wishName: String? = null,
    val wishUrl: String? = null,
    val wishDescription: String? = null,
) {
    companion object {
        const val PARAM_USER_ID = "userId"
        const val PARAM_WISH_ID = "wishId"
        const val PARAM_WISH_NAME = "wishName"
        const val PARAM_WISH_URL = "wishUrl"
        const val PARAM_WISH_DESCRIPTION = "wishDescription"

        fun fromUrl(url: Url): DeeplinkParams {
            val userId = url.parameters[PARAM_USER_ID]
            val wishId = url.parameters[PARAM_WISH_ID]
            val wishName = url.parameters[PARAM_WISH_NAME]
            val wishUrl = url.parameters[PARAM_WISH_URL]
            val wishDescription = url.parameters[PARAM_WISH_DESCRIPTION]
            return DeeplinkParams(
                userId = userId,
                wishId = wishId,
                wishUrl = wishUrl,
                wishDescription = wishDescription,
                wishName = wishName
            )
        }
    }
}