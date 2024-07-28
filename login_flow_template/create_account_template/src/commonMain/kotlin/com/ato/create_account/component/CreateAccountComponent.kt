package com.ato.create_account.component

import com.ato.create_account.ui.CreateAccountUiState
import kotlinx.coroutines.flow.Flow

interface CreateAccountComponent {
    val uiState: Flow<CreateAccountUiState?>

    fun onNameChanged(name: String)
    fun onNickChanged(nick: String)
    fun onCreateAccountClicked()
}

