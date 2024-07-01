package com.ato.folder.domain

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.value.MutableValue
import com.arkivanov.decompose.value.update
import com.arkivanov.essenty.instancekeeper.InstanceKeeper
import com.ato.folder.gateways.TemplateGateways
import com.ato.helpers.ResultOf
import com.ato.helpers.componentCoroutineScope
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

internal class TemplateDomain(
    componentContext: ComponentContext,
    initialState: TemplateModel?,
    private val gateways: TemplateGateways = TemplateGateways()
) : InstanceKeeper.Instance, CoroutineScope by componentContext.componentCoroutineScope() {

    val state: MutableStateFlow<ResultOf<TemplateModel?>> = MutableStateFlow(
        value = ResultOf.Loading(previous = initialState)
    )

    init {
        launch {
            gateways
                .getData()
                .collect { result: ResultOf<TemplateModel?> ->
                    state.update { result }
                }
        }
    }

    override fun onDestroy() {

    }

}

