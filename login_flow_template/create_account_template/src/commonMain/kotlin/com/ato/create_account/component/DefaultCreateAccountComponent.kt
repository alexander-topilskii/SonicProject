package com.ato.create_account.component

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.essenty.instancekeeper.getOrCreate
import com.ato.create_account.di.Di
import com.ato.create_account.gateways.CreateAccountGateways
import com.ato.create_account.ui.CreateAccountUiState
import com.ato.data_storage.AppContainer
import com.ato.helpers.componentCoroutineScope
import com.ato.helpers.createNotNullStateFlow
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import kotlinx.serialization.builtins.serializer

class DefaultCreateAccountComponent(
    private val componentContext: ComponentContext,
    private val appContainer: AppContainer,
) : CreateAccountComponent, ComponentContext by componentContext,
    CoroutineScope by componentContext.componentCoroutineScope() {

    private companion object {
        private const val KEY_STATE = "CreateAccount"
    }

    private val di = Di(appContainer)
    private val handler: CreateAccountGateways = instanceKeeper.getOrCreate(KEY_STATE) {
        CreateAccountGateways(
            componentContext = componentContext,
            di.getUserDao()
        )
    }

    override val uiState: Flow<CreateAccountUiState?> =
        createNotNullStateFlow(null) {
            handler.getData()
        }


    override fun onNameChanged(name: String) {
        handler.changeName(name)
    }

    override fun onNickChanged(nick: String) {
        handler.changeNick(nick)
    }

    override fun onCreateAccountClicked() {
        launch {
            handler.createAccount()
        }
    }
}


