package com.ato.folder.gateways

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.essenty.instancekeeper.InstanceKeeper
import com.ato.folder.ui.TemplateUiState
import com.ato.helpers.componentCoroutineScope
import com.ato.ui_state.base.button.UiButton
import com.ato.ui_state.base.text.UiTitle
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import wishlist.decompose_template.generated.resources.Res
import wishlist.decompose_template.generated.resources.folder_is_empty

internal class TemplateGateways(
    componentContext: ComponentContext,
    initialState: String?
) : InstanceKeeper.Instance, CoroutineScope by componentContext.componentCoroutineScope() {

    private val state: MutableStateFlow<TemplateUiState> = MutableStateFlow(
        TemplateUiState(
            templateTitle = UiTitle(
                title = Res.string.folder_is_empty,
                button = null
            )
        )
    )

    suspend fun getData(): Flow<TemplateUiState> {
        return state
    }
}