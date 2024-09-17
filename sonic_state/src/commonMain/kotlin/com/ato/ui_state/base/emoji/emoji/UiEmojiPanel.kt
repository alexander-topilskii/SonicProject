package com.ato.ui_state.base.emoji.emoji

data class UiEmojiPanel(
    val isShown: Boolean,
    val emojis: Map<String, UiEmojiData>?
)