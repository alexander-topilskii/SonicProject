package com.ato.template.component

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.essenty.instancekeeper.getOrCreate
import com.ato.template.gateways.TemplateGateways
import com.ato.template.ui.TemplateUiState
import com.ato.helpers.componentCoroutineScope
import com.ato.helpers.createNotNullStateFlow
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.Flow
import kotlinx.serialization.builtins.serializer

class DefaultTemplateComponent(
    private val componentContext: ComponentContext,
//    private val appContainer: AppContainer,
) : TemplateComponent, ComponentContext by componentContext,
    CoroutineScope by componentContext.componentCoroutineScope() {

    private companion object {
        private const val KEY_STATE = "Template"
    }

    private val handler: TemplateGateways = instanceKeeper.getOrCreate(KEY_STATE) {
        TemplateGateways(
            componentContext = componentContext,
            initialState = stateKeeper.consume(
                key = KEY_STATE,
                strategy = String.serializer()
            )
        )
    }

    override val uiState: Flow<TemplateUiState?> =
        createNotNullStateFlow(null) {
            handler.getData()
        }

    override fun onBackClicked() {

    }
}


