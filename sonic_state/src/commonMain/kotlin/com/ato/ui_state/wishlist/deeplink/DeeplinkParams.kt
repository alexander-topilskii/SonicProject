package com.ato.ui_state.wishlist.deeplink

import io.ktor.http.Url
import io.ktor.http.encodeURLParameter
import kotlinx.serialization.Serializable

@Serializable
data class DeeplinkParams(
    val userId: String? = null,
    val wishId: String? = null,
    val boardId: String? = null,
    val wishName: String? = null,
    val wishUrl: String? = null,
    val wishDescription: String? = null,
) {
    companion object {
        const val PARAM_USER_ID = "userId"
        const val PARAM_WISH_ID = "wishId"
        const val PARAM_BOARD_ID = "boardId"
        const val PARAM_WISH_NAME = "wishName"
        const val PARAM_WISH_URL = "wishUrl"
        const val PARAM_WISH_DESCRIPTION = "wishDescription"

        fun fromUrl(url: Url): DeeplinkParams {
            val userId = url.parameters[PARAM_USER_ID]
            val wishId = url.parameters[PARAM_WISH_ID]
            val boardId = url.parameters[PARAM_BOARD_ID]
            val wishName = url.parameters[PARAM_WISH_NAME]
            val wishUrl = url.parameters[PARAM_WISH_URL]
            val wishDescription = url.parameters[PARAM_WISH_DESCRIPTION]
            return DeeplinkParams(
                userId = userId,
                wishId = wishId,
                boardId = boardId,
                wishUrl = wishUrl,
                wishDescription = wishDescription,
                wishName = wishName
            )
        }


    }

    fun toQueryString(): String {
        val params = mutableListOf<String>()
        userId?.let { params.add("$PARAM_USER_ID=${it.encodeURLParameter()}") }
        wishId?.let { params.add("$PARAM_WISH_ID=${it.encodeURLParameter()}") }
        boardId?.let { params.add("$PARAM_BOARD_ID=${it.encodeURLParameter()}") }
        wishName?.let { params.add("$PARAM_WISH_NAME=${it.encodeURLParameter()}") }
        wishUrl?.let { params.add("$PARAM_WISH_URL=${it.encodeURLParameter()}") }
        wishDescription?.let { params.add("$PARAM_WISH_DESCRIPTION=${it.encodeURLParameter()}") }
        return params.joinToString(separator = "&")
    }
}