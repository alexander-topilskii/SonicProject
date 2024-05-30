package com.ato.ui_state.ikirag

import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.Junction
import androidx.room.PrimaryKey
import androidx.room.Relation
import kotlinx.serialization.Serializable

@Serializable
@Entity(tableName = "ikirags")
data class IkiragData(
    val text: String,
    val isLiked: Boolean? = null,
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0L
)

@Serializable
@Entity(
    tableName = "tags",
    indices = [Index(value = ["name"], unique = true)]
)
data class Tag(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0L,
    val isSelected: Boolean = false,
    @ColumnInfo(name = "name")
    val name: String
)

@Serializable
@Entity(
    tableName = "ikirags_tags",
    primaryKeys = ["ikiragId", "tagId"],
    foreignKeys = [
        ForeignKey(
            entity = IkiragData::class,
            parentColumns = ["id"],
            childColumns = ["ikiragId"],
            onDelete = ForeignKey.CASCADE
        ),
        ForeignKey(
            entity = Tag::class,
            parentColumns = ["id"],
            childColumns = ["tagId"],
            onDelete = ForeignKey.CASCADE
        )
    ],
    indices = [
        Index(value = ["tagId"]),
        Index(value = ["ikiragId", "tagId"], unique = true)
    ]
)
data class IkiragTagCrossRef(
    val ikiragId: Long,
    val tagId: Long
)

data class IkiragWithTags(
    @Embedded val ikirag: IkiragData,
    @Relation(
        parentColumn = "id",
        entityColumn = "tagId",
        associateBy = Junction(IkiragTagCrossRef::class)
    )
    val tags: List<Tag>
)

