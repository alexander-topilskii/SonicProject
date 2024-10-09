package com.ato.ui_state.wishlist.deeplink

import com.ato.ui_state.wishlist.deeplink.DeepLinkData.Companion.ADD_WISH
import com.ato.ui_state.wishlist.deeplink.DeepLinkData.Companion.BOARD
import com.ato.ui_state.wishlist.deeplink.DeepLinkData.Companion.FRIENDS
import com.ato.ui_state.wishlist.deeplink.DeepLinkData.Companion.PERSON
import com.ato.ui_state.wishlist.deeplink.DeepLinkData.Companion.WISH
import com.ato.ui_state.wishlist.deeplink.DeepLinkData.Companion.WISHES

object DeeplinkCreator {

    val addWishDeeplink
        get() = DeepLinkData(
            pathSegments = listOf(WISHES, ADD_WISH),
            deeplinkParams = DeeplinkParams()
        )

    val shareWishDeeplink
        get() = DeepLinkData(
            pathSegments = listOf(FRIENDS, PERSON, BOARD, WISH),
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

    fun shareWishDeeplink(userId: String, boardId: String?, wishId: String): DeepLinkData {
        return shareWishDeeplink.copy(
            deeplinkParams = shareWishDeeplink.deeplinkParams.copy(
                userId = userId,
                wishId = wishId,
                boardId = boardId
            )
        )
    }
}