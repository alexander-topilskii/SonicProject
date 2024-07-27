package com.ato.data_storage

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    entities = [
        TemplateData::class,
    ],
    version = 1,
    exportSchema = false
)
abstract class TemplateDataBase : RoomDatabase(), DB {
    abstract fun templateDao(): TemplateDao

    override fun clearAllTables() {
        super.clearAllTables()
    }
}

// FIXME: Added a hack to resolve below issue:
// Class 'AppDatabase_Impl' is not abstract and does not implement abstract base class member 'clearAllTables'.
interface DB {
    fun clearAllTables() {}
}