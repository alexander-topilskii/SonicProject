package com.ato.login_root.component

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.essenty.instancekeeper.getOrCreate
import com.ato.data_storage.AppContainer
import com.ato.helpers.componentCoroutineScope
import com.ato.helpers.createNotNullStateFlow
import com.ato.login_root.domain.LoginRootDomain
import com.ato.login_root.ui.LoginRootUiState
import dev.gitlive.firebase.auth.FirebaseUser
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class DefaultLoginRootComponent(
    private val componentContext: ComponentContext,
    private val appContainer: AppContainer,
) : LoginRootComponent, ComponentContext by componentContext,
    CoroutineScope by componentContext.componentCoroutineScope() {

    private companion object {
        private const val KEY_STATE = "LoginRoot"
    }

    private val di = Di(appContainer)
    private val handler: LoginRootDomain =
        instanceKeeper.getOrCreate(KEY_STATE) {
            LoginRootDomain(
                componentContext = componentContext,
                usersDao = di.getUserDao(),
                authDao = di.getAuthDao(),
            )
        }

    override val uiState: StateFlow<LoginRootUiState?> =
        createNotNullStateFlow(null) {
            handler.getData()
        }

    override fun onEmailChanged(newEmail: String) {
        handler.setEmail(newEmail)
    }

    override fun onPasswordChanged(newPassword: String) {
        handler.setPassword(newPassword)
    }

    override fun onLoginClicked() {
        launch {
            handler.login()
        }
    }

    override fun onRepeatPasswordChanged(newRepeatPassword: String) {
        handler.setRepeatPassword(newRepeatPassword)
    }

    override fun onSignUpClicked() {
        launch {
            handler.signUp()
        }
    }

    override fun onSigned(result: Result<FirebaseUser?>) {
        // do nothing
    }
}
