package com.ato.folder.gateways

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.essenty.instancekeeper.InstanceKeeper
import com.ato.folder.ui.TemplateUiState
import com.ato.helpers.componentCoroutineScope
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.flowOf

internal class TemplateGateways(
    componentContext: ComponentContext,
    initialState: String?
) : InstanceKeeper.Instance, CoroutineScope by componentContext.componentCoroutineScope() {

    private val mutableStateFlow: MutableStateFlow<TemplateUiState> = MutableStateFlow(
        TemplateUiState("")
    )

    suspend fun getData(): Flow<TemplateUiState> {
        return mutableStateFlow
    }
}

//private fun ApodResponse.toModel(): TemplateModel {
//    return TemplateModel(this.date?.length?: 0)
//}