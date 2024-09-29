package com.ato.ui_state.template.deeplink

import com.ato.ui_state.template.deeplink.DeepLinkTemplateData.Companion.APP
import com.ato.ui_state.template.deeplink.DeepLinkTemplateData.Companion.HOST
import com.ato.ui_state.template.deeplink.DeepLinkTemplateData.Companion.SCHEME

object DeeplinkTemplateCreator {

    val addWishDeeplink
        get() = DeepLinkTemplateData(
            scheme = SCHEME,
            host = HOST,
            pathSegments = listOf(APP),
            deeplinkParams = DeeplinkTemplateParams()
        )

    fun getAddWishDeepLink(name: String?, description: String?, url: String?): DeepLinkTemplateData {
        return addWishDeeplink.copy(deeplinkParams = addWishDeeplink.deeplinkParams.copy(
            )
        )
    }
}