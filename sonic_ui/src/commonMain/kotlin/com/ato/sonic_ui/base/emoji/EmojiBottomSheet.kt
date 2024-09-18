package com.ato.sonic_ui.base.emoji

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.rememberCoroutineScope
import com.ato.ui_state.base.emoji.UiEmojiData
import com.ato.ui_state.base.emoji.UiEmojiPanel
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EmojiBottomSheet(
    state: UiEmojiPanel,
    onDismissRequest: () -> Unit,
    onEmojiClicked: (String, UiEmojiData) -> Unit,
    header: @Composable () -> Unit
) {
    // Создаем состояние для управления `BottomSheet`
    val bottomSheetState = rememberModalBottomSheetState()
    val coroutineScope = rememberCoroutineScope()

    // Показываем `BottomSheet`, если эмодзи не равны null
    LaunchedEffect(state.isShown) {
        if (state.isShown) {
            coroutineScope.launch {
                bottomSheetState.show()
            }
        } else {
            coroutineScope.launch {
                bottomSheetState.hide()
            }
        }
    }

    if (state.isShown) {
        ModalBottomSheet(
            sheetState = bottomSheetState,
            onDismissRequest = onDismissRequest,
            containerColor = MaterialTheme.colorScheme.surfaceVariant,
            content = {
                Column {
                    header()
                    state.emojis?.let {
                        EmojiGrid(
                            emojis = it,
                            onEmojiClicked = onEmojiClicked
                        )
                    }
                }
            }
        )
    }
}
