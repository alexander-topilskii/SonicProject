package com.ato.ui_state.template.deeplink

import com.ato.ui_state.template.deeplink.DeepLinkData.Companion.APP
import com.ato.ui_state.template.deeplink.DeepLinkData.Companion.HOST
import com.ato.ui_state.template.deeplink.DeepLinkData.Companion.SCHEME

object DeeplinkCreator {

    val addWishDeeplink
        get() = DeepLinkData(
            scheme = SCHEME,
            host = HOST,
            pathSegments = listOf(APP),
            deeplinkParams = DeeplinkParams()
        )

    fun getAddWishDeepLink(name: String?, description: String?, url: String?): DeepLinkData {
        return addWishDeeplink.copy(deeplinkParams = addWishDeeplink.deeplinkParams.copy(
            )
        )
    }
}