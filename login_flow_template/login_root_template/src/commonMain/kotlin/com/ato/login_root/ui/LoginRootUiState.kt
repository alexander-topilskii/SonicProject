package com.ato.login_root.ui

import com.ato.ui_state.base.button.UiButton
import com.ato.ui_state.base.input.UiEditTextState
import com.ato.ui_state.base.text.UiSimpleText

data class LoginRootUiState(
    val email: UiEditTextState,
    val password: UiEditTextState,
    val loginButton: UiButton?,
    val createExplain: UiSimpleText?,
    val repeatPassword: UiEditTextState?,
    val signUpButton: UiButton?,
    val orText: UiSimpleText,
)