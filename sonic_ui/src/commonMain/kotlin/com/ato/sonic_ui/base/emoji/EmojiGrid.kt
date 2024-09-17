package com.ato.sonic_ui.base.emoji

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.text.BasicText
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.text.TextStyle
import com.ato.ui_state.base.emoji.emoji.UiEmojiData


@Composable
fun EmojiGrid(
    emojis: Map<String, UiEmojiData>?,
    onEmojiClicked: (String, UiEmojiData) -> Unit,
) {
    emojis ?: return

    if (emojis.isNotEmpty()) {
        val emojiList = emojis.entries.toList()

        LazyColumn(
            contentPadding = PaddingValues(8.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(emojiList.chunked(5)) { rowEmojis ->
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    for ((emojiChar, emojiData) in rowEmojis) {
                        Box(
                            modifier = Modifier.weight(1f),
                            contentAlignment = Alignment.Center
                        ) {
                            Column(
                                horizontalAlignment = Alignment.CenterHorizontally
                            ) {
                                BasicText(
                                    text = emojiChar,
                                    style = TextStyle(fontSize = 28.sp),
                                    modifier = Modifier.clickable {
                                        onEmojiClicked.invoke(emojiChar, emojiData)
                                    }
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}
