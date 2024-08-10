package com.ato.data_storage

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy

@Dao
interface TemplateDao {
    // Existing functions
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(value: TemplateData): Long

}
