package com.ato.ui_state.ikirag

import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.serialization.Serializable

@Serializable
@Entity(tableName = "ikirags")
data class IkiragData(
    val text: String,
    val tag: String? = null,
    val isLiked: Boolean? = null,
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0L,
)