package com.ato.sonic_repository

import app.cash.sqldelight.db.SqlDriver
import com.ato.Mood

class RepositoryDependencies(driver: SqlDriver) {

    val database by lazy {
        Database(
            driver = driver,
            MoodAdapter = Mood.Adapter(
                timeAdapter = TimeAdapter
            )
        )
    }
}