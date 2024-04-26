package com.ato.template

import com.ato.sonic_repository.Database
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import kotlin.coroutines.CoroutineContext

internal class TemplateRepository(
    private val database: Database,
    private val coroutineContext: CoroutineContext
) {

    fun getState(): Flow<UiTemplateState> {
        return flowOf(UiTemplateState("text"))
//        return database.moodsQueries
//            .selectAll()
//            .asFlow()
//            .mapToList(coroutineContext)
//            .map { moods -> moods.toState() }
    }
}