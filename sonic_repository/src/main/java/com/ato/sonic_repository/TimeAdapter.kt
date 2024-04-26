package com.ato.sonic_repository

import app.cash.sqldelight.ColumnAdapter
import java.lang.Exception
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale
import java.util.Optional

object TimeAdapter : ColumnAdapter<Optional<Date>, String> {

    private val dateFormat = SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.ROOT)

    override fun decode(databaseValue: String): Optional<Date> {
        return try {
            Optional.of(dateFormat.parse(databaseValue) ?: Date())
        } catch (e: Exception) {
            Optional.empty()
        }
    }

    override fun encode(value: Optional<Date>): String {
        if (value.isPresent) return "0"

        return dateFormat.format(value.get())
    }
}