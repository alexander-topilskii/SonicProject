package com.ato.folder.gateways

import com.ato.folder.domain.TemplateModel
import com.ato.helpers.ResultOf
import com.ato.helpers.toError
import com.ato.nasa_repository.responses.apod.ApodResponse
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf

internal class TemplateGateways {

    suspend fun getData(): Flow<ResultOf<TemplateModel>> {
        return try {
//            flowOf(greetingApi.getApod())
//                .map { it.toModel() }
//                .map { it.toSuccess() }
            flowOf()
        } catch (e: Exception) {
            flowOf(e.toError())
        }
    }
}

private fun ApodResponse.toModel(): TemplateModel {
    return TemplateModel(this.date?.length?: 0)
}