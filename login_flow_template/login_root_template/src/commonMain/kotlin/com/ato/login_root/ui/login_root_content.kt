package com.ato.login_root.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.ato.login_root.component.LoginRootComponent
import com.ato.sonic_ui.base.button.DisplayButton
import com.ato.sonic_ui.base.input.DisplayEditablePassword
import com.ato.sonic_ui.base.input.DisplayEditableText
import com.ato.sonic_ui.base.text.DisplayText
import com.mmk.kmpauth.firebase.apple.AppleButtonUiContainer
import com.mmk.kmpauth.firebase.google.GoogleButtonUiContainerFirebase
import com.mmk.kmpauth.uihelper.apple.AppleButtonMode
import com.mmk.kmpauth.uihelper.apple.AppleSignInButton
import com.mmk.kmpauth.uihelper.google.GoogleSignInButton
import org.jetbrains.compose.resources.stringResource


@Composable
fun LoginRootContent(
    component: LoginRootComponent,
    modifier: Modifier = Modifier
) {
    val model by component.uiState.collectAsState()

    model?.let { data ->
        Box(
            modifier = modifier
                .fillMaxSize(),
        ) {
            Column(
                modifier = Modifier
                    .align(Alignment.Center)
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp)
                    .verticalScroll(rememberScrollState())
            ) {
                DisplayEditableText(
                    state = data.email,
                    onValueChanged = component::onEmailChanged,
                    modifier = Modifier.fillMaxWidth()
                )
                DisplayEditablePassword(
                    state = data.password,
                    onValueChanged = component::onPasswordChanged,
                    modifier = Modifier.fillMaxWidth(),
                    onDone = component::onLoginClicked
                )
                data.loginButton?.let { loginButton ->
                    DisplayButton(
                        state = loginButton,
                        onClick = component::onLoginClicked,
                        modifier = Modifier.fillMaxWidth()
                    )
                }
                data.createExplain?.let { createExplain ->
                    DisplayText(
                        state = createExplain,
                        modifier = Modifier.fillMaxWidth()
                    )
                }
                Spacer(Modifier.height(2.dp))
                data.repeatPassword?.let { repeatPassword ->
                    DisplayEditablePassword(
                        state = repeatPassword,
                        onValueChanged = component::onRepeatPasswordChanged,
                        modifier = Modifier.fillMaxWidth(),
                        onDone = component::onSignUpClicked
                    )
                }
                data.signUpButton?.let { signUpButton ->
                    DisplayButton(
                        state = signUpButton,
                        onClick = component::onSignUpClicked,
                        modifier = Modifier.fillMaxWidth().height(44.dp)
                    )
                }
                Spacer(Modifier.height(4.dp))
                Text(
                    text = stringResource(data.orText.text),
                    modifier = Modifier.fillMaxWidth(),
                    textAlign = TextAlign.Center
                )
                Spacer(Modifier.height(4.dp))
                GoogleButtonUiContainerFirebase(onResult = component::onSigned) {
                    GoogleSignInButton(modifier = Modifier.fillMaxWidth()) {
                        this.onClick()
                    }
                }

//                AppleButtonUiContainer(
//                    modifier = Modifier.fillMaxWidth().height(44.dp),
//                    onResult = component::onSigned
//                ) {
//                    AppleSignInButton(
//                        modifier = Modifier.fillMaxWidth(),
//                        mode = AppleButtonMode.WhiteWithOutline
//                    ) {
//                        this.onClick()
//                    }
//                }
            }
        }
    }
}
