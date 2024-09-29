package com.ato.ui_state.template.deeplink

import io.ktor.http.Url
import io.ktor.http.encodeURLParameter
import kotlinx.serialization.Serializable

@Serializable
data class DeeplinkTemplateParams(
    val userId: String? = null,
) {
    companion object {
        const val PARAM_USER_ID = "userId"

        fun fromUrl(url: Url): DeeplinkTemplateParams {
            val userId = url.parameters[PARAM_USER_ID]
            return DeeplinkTemplateParams(
                userId = userId,
            )
        }


    }

    fun toQueryString(): String {
        val params = mutableListOf<String>()
        userId?.let { params.add("$PARAM_USER_ID=${it.encodeURLParameter()}") }
        return params.joinToString(separator = "&")
    }
}