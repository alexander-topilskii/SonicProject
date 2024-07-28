package com.ato.splash.gateways

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.essenty.instancekeeper.InstanceKeeper
import com.ato.splash.ui.SplashUiState
import com.ato.helpers.componentCoroutineScope
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf

internal class SplashGateways(
    componentContext: ComponentContext,
    initialState: String?
) : InstanceKeeper.Instance, CoroutineScope by componentContext.componentCoroutineScope() {

    suspend fun getData(): Flow<SplashUiState> {
        return try {
//            flowOf(greetingApi.getApod())
//                .map { it.toModel() }
//                .map { it.toSuccess() }
            flowOf()
        } catch (e: Exception) {
            e.printStackTrace()
            flowOf()
        }
    }
}

//private fun ApodResponse.toModel(): SplashModel {
//    return SplashModel(this.date?.length?: 0)
//}