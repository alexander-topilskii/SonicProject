package com.ato.ui_state.base.emoji

import kotlinx.serialization.json.Json

// Класс API для получения эмодзи
class EmojiApi {

    // Функция для получения эмодзи из локальной строки
    suspend fun getEmojis(): Map<String, UiEmojiData> {
        return Json.decodeFromString(emojiJsonString)
    }
}