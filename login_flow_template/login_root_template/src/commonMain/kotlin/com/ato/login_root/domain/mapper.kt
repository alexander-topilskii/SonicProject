package com.ato.login_root.domain

import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import com.ato.login_root.ui.LoginRootUiState
import com.ato.ui_state.base.button.UiButton
import com.ato.ui_state.base.input.UiEditTextState
import com.ato.ui_state.base.text.UiSimpleText
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update
import wishlist.login_flow.login_root.generated.resources.Res
import wishlist.login_flow.login_root.generated.resources.login_email_cannot_be_empty
import wishlist.login_flow.login_root.generated.resources.login_email_is_already_in_use
import wishlist.login_flow.login_root.generated.resources.login_entered_email_is_invalid
import wishlist.login_flow.login_root.generated.resources.login_password_cannot_be_empty
import wishlist.login_flow.login_root.generated.resources.login_password_too_week
import wishlist.login_flow.login_root.generated.resources.login_passwords_is_not_match
import wishlist.login_flow.login_root.generated.resources.login_repeat_password
import wishlist.login_flow.login_root.generated.resources.login_repeat_password_cannot_be_empty
import wishlist.login_flow.login_root.generated.resources.login_sign_up
import wishlist.login_flow.login_root.generated.resources.login_user_not_found


internal fun MutableStateFlow<LoginRootUiState>.emailInUse() {
    update {
        it.copy(
            email = it.email.copy(errorText = Res.string.login_email_is_already_in_use)
        )
    }
}

internal fun MutableStateFlow<LoginRootUiState>.emailInvalid() {
    update {
        it.copy(
            email = it.email.copy(errorText = Res.string.login_entered_email_is_invalid)
        )
    }
}

internal fun MutableStateFlow<LoginRootUiState>.updateEmail(newEmail: String) {
    update {
        it.copy(
            email = it.email.copy(
                inputText = newEmail,
                errorText = null
            )
        )
    }
}

internal fun MutableStateFlow<LoginRootUiState>.updatePassword(newPassword: String) {
    update {
        it.copy(
            password = it.password.copy(
                inputText = newPassword,
                errorText = null
            )
        )
    }
}

internal fun MutableStateFlow<LoginRootUiState>.newRepeatPassword(newRepeatPassword: String) {
    update {
        it.copy(
            repeatPassword = it.repeatPassword?.copy(
                inputText = newRepeatPassword,
                errorText = null
            )
        )
    }
}

internal fun MutableStateFlow<LoginRootUiState>.passwordTooWeak() {
    update {
        it.copy(
            repeatPassword = it.repeatPassword?.copy(errorText = Res.string.login_password_too_week),
            password = it.password.copy(errorText = Res.string.login_password_too_week),
        )
    }
}

internal fun MutableStateFlow<LoginRootUiState>.invalidUser() {
    update {
        it.copy(
            createExplain = UiSimpleText(text = Res.string.login_user_not_found),
            loginButton = null,
            repeatPassword = UiEditTextState(
                title = Res.string.login_repeat_password,
                inputText = "",
                keyboardType = KeyboardType.Password,
                keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Done),
            ),
            signUpButton = UiButton(
                title = Res.string.login_sign_up,
            ),
        )
    }
}

internal fun MutableStateFlow<LoginRootUiState>.setPasswordEmpty() {
    update {
        it.copy(
            password = it.password.copy(errorText = Res.string.login_password_cannot_be_empty)
        )
    }
}

internal fun MutableStateFlow<LoginRootUiState>.setRepeatPasswordEmpty() {
    update {
        it.copy(
            repeatPassword = it.repeatPassword?.copy(errorText = Res.string.login_repeat_password_cannot_be_empty)
        )
    }
}

internal fun MutableStateFlow<LoginRootUiState>.signUpProcess(isLoading: Boolean) {
    update {
        it.copy(
            signUpButton = it.signUpButton?.copy(isLoading = isLoading)
        )
    }
}


internal fun MutableStateFlow<LoginRootUiState>.loginProcess(isLoading: Boolean) {
    update {
        it.copy(
            loginButton = it.loginButton?.copy(isLoading = isLoading)
        )
    }
}


internal fun MutableStateFlow<LoginRootUiState>.setPasswordAreDifferent() {
    update {
        it.copy(
            repeatPassword = it.repeatPassword?.copy(errorText = Res.string.login_passwords_is_not_match),
            password = it.password.copy(errorText = Res.string.login_passwords_is_not_match),
        )
    }
}

internal fun MutableStateFlow<LoginRootUiState>.setEmailEmpty() {
    update {
        it.copy(
            email = it.email.copy(errorText = Res.string.login_email_cannot_be_empty)
        )
    }
}

internal fun MutableStateFlow<LoginRootUiState>.setEmailNormalState() {
    update {
        it.copy(
            email = it.email.copy(errorText = null)
        )
    }
}

internal fun MutableStateFlow<LoginRootUiState>.setPasswordNormalState() {
    update {
        it.copy(
            password = it.password.copy(errorText = null)
        )
    }
}


internal fun MutableStateFlow<LoginRootUiState>.setRepeatPasswordNormalState() {
    update {
        it.copy(
            repeatPassword = it.repeatPassword?.copy(errorText = null)
        )
    }
}