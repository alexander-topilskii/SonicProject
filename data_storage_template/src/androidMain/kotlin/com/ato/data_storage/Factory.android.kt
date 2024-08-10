package com.ato.data_storage

import android.app.Application
import androidx.room.Room


actual class Factory(private val app: Application) {
    actual fun createRoomDatabase(): TemplateDataBase {
        return Room.databaseBuilder(
            app,
            TemplateDataBase::class.java,
            "dbFileName"
        )
            .fallbackToDestructiveMigration(false)
            .build()
    }
}
