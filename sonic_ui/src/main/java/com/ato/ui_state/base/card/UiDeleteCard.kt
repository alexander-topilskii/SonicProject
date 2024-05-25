package com.ato.ui_state.base.card

import com.ato.ui_state.Ui

data class UiDeleteCard(
    val content: String,
    val isLiked: Boolean? = null,
    override val id: Long = 0L,
): Ui