package com.ato.sonic_ui.base.modifiers

import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.pointer.pointerInput


fun Modifier.onTap(action: () -> Unit) = this.pointerInput(Unit) {
    detectTapGestures(
        onTap = {
            action.invoke()
        }
    )
}
