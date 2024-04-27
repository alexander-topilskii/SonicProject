package com.ato.ui_state.ikirag

import kotlinx.serialization.Serializable

@Serializable
data class UiIkiragPiece(
    val text: String,
    val tag: String? = null,
    val isLiked: Boolean? = null
)

object IkiragSamples {
    val item = UiIkiragPiece(
        text = """
            Не в силах нас ни смех,  ни грех 
            свернуть с пути отважного,
              мы  строим счастье сразу всех,  
            и нам плевать на каждого.
        """.trimIndent()
    )
}
