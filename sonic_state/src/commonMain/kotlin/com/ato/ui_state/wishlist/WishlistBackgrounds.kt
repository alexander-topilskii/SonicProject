package com.ato.ui_state.wishlist

import kotlinx.serialization.Serializable

@Serializable
data class WishlistBackgrounds(
    val backgrounds: List<String>? = null,
)

@Serializable
data class Backgrounds(
    val groups: List<BackgroundGroup>? = null,
)

@Serializable
data class BackgroundGroup(
    val name: String,
    val items: List<Item>
)

@Serializable
data class Item(
    val name: String?,
    val url: String
)