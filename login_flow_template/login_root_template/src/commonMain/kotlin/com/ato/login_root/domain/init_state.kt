package com.ato.login_root.domain

import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import com.ato.login_root.ui.LoginRootUiState
import com.ato.ui_state.base.button.UiButton
import com.ato.ui_state.base.input.UiEditTextState
import com.ato.ui_state.base.text.UiSimpleText
import kotlinx.coroutines.flow.MutableStateFlow
import minimalisticflashcards.login_root_template.generated.resources.Res
import minimalisticflashcards.login_root_template.generated.resources.login_email
import minimalisticflashcards.login_root_template.generated.resources.login_login_button
import minimalisticflashcards.login_root_template.generated.resources.login_or
import minimalisticflashcards.login_root_template.generated.resources.login_password

fun getInitState() = MutableStateFlow(
    LoginRootUiState(
        email = UiEditTextState(
            title = Res.string.login_email,
            inputText = "",
            keyboardType = KeyboardType.Email,
            keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Next),
            maxLines = 1
        ),
        password = UiEditTextState(
            title = Res.string.login_password,
            inputText = "",
            keyboardType = KeyboardType.Password,
            keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Done),
            maxLines = 1
        ),
        loginButton = UiButton(
            title = Res.string.login_login_button,
        ),
        createExplain = null,
        repeatPassword = null,
        signUpButton = null,
        orText = UiSimpleText(Res.string.login_or)
    )
)