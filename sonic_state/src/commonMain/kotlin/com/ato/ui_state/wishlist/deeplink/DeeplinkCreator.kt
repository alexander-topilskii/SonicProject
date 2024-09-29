package com.ato.ui_state.wishlist.deeplink

import com.ato.ui_state.wishlist.deeplink.DeepLinkData.Companion.ADD_WISH
import com.ato.ui_state.wishlist.deeplink.DeepLinkData.Companion.APP
import com.ato.ui_state.wishlist.deeplink.DeepLinkData.Companion.HOST
import com.ato.ui_state.wishlist.deeplink.DeepLinkData.Companion.SCHEME
import com.ato.ui_state.wishlist.deeplink.DeepLinkData.Companion.WISHES

object DeeplinkCreator {

    val addWishDeeplink
        get() = DeepLinkData(
            scheme = SCHEME,
            host = HOST,
            pathSegments = listOf(APP, WISHES, ADD_WISH),
            deeplinkParams = DeeplinkParams()
        )

    fun getAddWishDeepLink(name: String?, description: String?, url: String?): DeepLinkData {
        return addWishDeeplink.copy(
            deeplinkParams = addWishDeeplink.deeplinkParams.copy(
                wishName = name,
                wishDescription = description,
                wishUrl = url
            )
        )
    }
}