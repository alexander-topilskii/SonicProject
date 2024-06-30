package com.ato.ui_state.ikirag

import com.ato.ui_state.Ui

data class IkiragUi(
    val text: String,
    val isLiked: Boolean? = null,
    override val id: Long = 0L
) : Ui