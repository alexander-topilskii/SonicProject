package com.ato.data_storage

import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.serialization.Serializable

@Serializable
@Entity(tableName = "wishlist")
data class TemplateData(
    val text: String,
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0L
)


