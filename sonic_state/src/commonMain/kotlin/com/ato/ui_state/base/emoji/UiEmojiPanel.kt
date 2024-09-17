package com.ato.ui_state.base.emoji

// https://k3a.me/telegram-emoji-list-codes-descriptions/
// чтобы сделать красивее нужно парсить картинки ^
data class UiEmojiPanel(
    val isShown: Boolean,
    val emojis: Map<String, UiEmojiData>?
)