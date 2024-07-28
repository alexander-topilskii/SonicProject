package com.ato.create_account.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.ato.create_account.component.CreateAccountComponent
import com.ato.sonic_ui.base.button.DisplayButton
import com.ato.sonic_ui.base.input.DisplayEditableText


@Composable
fun CreateAccountContent(
    component: CreateAccountComponent,
    modifier: Modifier = Modifier
) {
    val model by component.uiState.collectAsState(null)

    model?.let { data ->
        Box(
            modifier = modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Column(
                modifier = Modifier
                    .align(Alignment.Center)
                    .padding(start = 16.dp, end = 16.dp)
                    .verticalScroll(rememberScrollState())
            ) {
                DisplayEditableText(
                    state = data.userName,
                    onValueChanged = component::onNameChanged,
                )
                DisplayEditableText(
                    state = data.userNick,
                    onValueChanged = component::onNickChanged
                )
                DisplayButton(
                    state = data.createAccount,
                    onClick = component::onCreateAccountClicked
                )
            }
        }
    }
}
