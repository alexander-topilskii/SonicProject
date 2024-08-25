package com.ato.ui_state.wishlist.deeplink

import com.ato.ui_state.wishlist.deeplink.DeepLinkData1.Companion.ADD_WISH
import com.ato.ui_state.wishlist.deeplink.DeepLinkData1.Companion.APP
import com.ato.ui_state.wishlist.deeplink.DeepLinkData1.Companion.HOST
import com.ato.ui_state.wishlist.deeplink.DeepLinkData1.Companion.SCHEME
import com.ato.ui_state.wishlist.deeplink.DeepLinkData1.Companion.WISHES

object DeeplinkCreator1 {

    val addWishDeeplink
        get() = DeepLinkData1(
            scheme = SCHEME,
            host = HOST,
            pathSegments = listOf(APP, WISHES, ADD_WISH),
            deeplinkParams = DeeplinkParams1()
        )

    fun getAddWishDeepLink(name: String?, description: String?, url: String?): DeepLinkData1 {
        return addWishDeeplink.copy(
            deeplinkParams = addWishDeeplink.deeplinkParams.copy(
                wishName = name,
                wishDescription = description,
                wishUrl = url
            )
        )
    }
}