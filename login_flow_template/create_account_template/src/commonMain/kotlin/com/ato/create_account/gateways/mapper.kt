package com.ato.create_account.gateways

import androidx.compose.ui.text.input.KeyboardType
import com.ato.create_account.ui.CreateAccountUiState
import com.ato.ui_state.base.button.UiButton
import com.ato.ui_state.base.input.UiEditTextState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update
import minimalisticflashcards.create_account_template.generated.resources.Res
import minimalisticflashcards.create_account_template.generated.resources.create_account_name
import minimalisticflashcards.create_account_template.generated.resources.create_account_button
import minimalisticflashcards.create_account_template.generated.resources.create_account_name_empty
import minimalisticflashcards.create_account_template.generated.resources.create_account_nick
import minimalisticflashcards.create_account_template.generated.resources.create_account_nick_empty
import minimalisticflashcards.create_account_template.generated.resources.create_account_nick_long
import minimalisticflashcards.create_account_template.generated.resources.create_account_nick_short
import minimalisticflashcards.create_account_template.generated.resources.create_account_nick_taken
import minimalisticflashcards.create_account_template.generated.resources.create_account_nick_unavailable


internal fun getInitState() = MutableStateFlow(
    CreateAccountUiState(
        userName = UiEditTextState(
            title = Res.string.create_account_name,
            inputText = "",
            keyboardType = KeyboardType.Text
        ),
        userNick = UiEditTextState(
            title = Res.string.create_account_nick,
            inputText = "",
            keyboardType = KeyboardType.Text
        ),
        createAccount = UiButton(
            title = Res.string.create_account_button,
        )
    )
)

internal fun MutableStateFlow<CreateAccountUiState>.nameEmpty() {
    update {
        it.copy(
            userName = it.userName.copy(errorText = Res.string.create_account_name_empty)
        )
    }
}

internal fun MutableStateFlow<CreateAccountUiState>.nickEmpty() {
    update {
        it.copy(
            userNick = it.userNick.copy(errorText = Res.string.create_account_nick_empty)
        )
    }
}


internal fun MutableStateFlow<CreateAccountUiState>.nickShort() {
    update {
        it.copy(
            userNick = it.userNick.copy(errorText = Res.string.create_account_nick_short)
        )
    }
}

internal fun MutableStateFlow<CreateAccountUiState>.nickLong() {
    update {
        it.copy(
            userNick = it.userNick.copy(errorText = Res.string.create_account_nick_long)
        )
    }
}

internal fun MutableStateFlow<CreateAccountUiState>.nickContainsUnavailableLetters() {
    update {
        it.copy(
            userNick = it.userNick.copy(errorText = Res.string.create_account_nick_unavailable)
        )
    }
}


internal fun MutableStateFlow<CreateAccountUiState>.nickTaken() {
    update {
        it.copy(
            userNick = it.userNick.copy(errorText = Res.string.create_account_nick_taken)
        )
    }
}