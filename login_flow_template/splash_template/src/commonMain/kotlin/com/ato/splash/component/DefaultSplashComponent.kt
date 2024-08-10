package com.ato.splash.component

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.essenty.instancekeeper.getOrCreate
import com.ato.data_storage.AppContainer
import com.ato.splash.gateways.SplashGateways
import com.ato.splash.ui.SplashUiState
import com.ato.helpers.componentCoroutineScope
import com.ato.helpers.createNotNullStateFlow
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import kotlinx.serialization.builtins.serializer

class DefaultSplashComponent(
    private val componentContext: ComponentContext,
    private val appContainer: AppContainer,
) : SplashComponent, ComponentContext by componentContext,
    CoroutineScope by componentContext.componentCoroutineScope() {

    private companion object {
        private const val KEY_STATE = "Splash"
    }

    private val handler: SplashGateways = instanceKeeper.getOrCreate(KEY_STATE) {
        SplashGateways(
            componentContext = componentContext,
            initialState = stateKeeper.consume(
                key = KEY_STATE,
                strategy = String.serializer()
            )
        )
    }

    override val uiState: Flow<SplashUiState?> =
        createNotNullStateFlow(null) {
            handler.getData()
        }

    override fun onItemClicked(item: String) {
        launch {

        }
    }
}


