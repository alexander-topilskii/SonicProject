package com.ato.folder.component

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.essenty.instancekeeper.getOrCreate
import com.ato.folder.domain.TemplateDomain
import com.ato.folder.domain.TemplateModel
import com.ato.folder.ui.TemplateUiState
import com.ato.helpers.ResultOf
import com.ato.helpers.componentCoroutineScope
import com.ato.helpers.map
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch

class DefaultTemplateComponent(
    private val componentContext: ComponentContext,
    private val item: String,
) : TemplateComponent, ComponentContext by componentContext,
    CoroutineScope by componentContext.componentCoroutineScope() {

    private companion object {
        private const val KEY_STATE = "Template"
    }

    private val handler: TemplateDomain = instanceKeeper.getOrCreate(KEY_STATE) {
        TemplateDomain(
            componentContext = componentContext,
            initialState = stateKeeper.consume(
                key = KEY_STATE,
                strategy = TemplateModel.serializer()
            )
        )
    }

    override val uiState: Flow<ResultOf<TemplateUiState?>> =
        handler.state.map { it.toApodUiState() }

    private fun ResultOf<TemplateModel?>.toApodUiState(): ResultOf<TemplateUiState?> =
        this.map { TemplateUiState(item) }

    override fun onItemClicked(item: String) {
        launch {

        }
    }
}


