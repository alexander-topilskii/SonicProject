package com.ato.create_account.ui

import com.ato.ui_state.base.button.UiButton
import com.ato.ui_state.base.input.UiEditTextState

data class CreateAccountUiState(
    val userName: UiEditTextState,
    val userNick: UiEditTextState,
    val createAccount: UiButton
)