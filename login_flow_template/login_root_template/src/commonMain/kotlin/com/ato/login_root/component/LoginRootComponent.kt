package com.ato.login_root.component

import com.ato.login_root.ui.LoginRootUiState
import com.ato.helpers.ResultOf
import dev.gitlive.firebase.auth.FirebaseUser
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.StateFlow

interface LoginRootComponent {
    val uiState: StateFlow<LoginRootUiState?>

    fun onEmailChanged(newEmail: String)
    fun onPasswordChanged(newPassword: String)
    fun onRepeatPasswordChanged(newRepeatPassword: String)
    fun onLoginClicked()
    fun onSignUpClicked()
    fun onSigned(result: Result<FirebaseUser?>)
}

