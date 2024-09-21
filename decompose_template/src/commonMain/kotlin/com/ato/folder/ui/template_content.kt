package com.ato.folder.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import com.ato.folder.component.TemplateComponent
import com.ato.sonic_ui.base.modifiers.onTap
import com.ato.sonic_ui.base.text.DisplayAppBarTitle
import com.ato.sonic_ui.date.DisplayDatePicker


@Composable
fun TemplateContent(
    component: TemplateComponent,
    modifier: Modifier = Modifier
) {
    val model by component.uiState.collectAsState(null)

    model?.let { data->
        val keyboardController = LocalSoftwareKeyboardController.current

        Scaffold(
            topBar = {
                DisplayAppBarTitle(
                    state = data.templateTitle,
                    onBackClicked = component::onBackClicked,
                    onClick = {  }
                )
            }
        ) {
            LazyColumn(
                modifier = modifier
                    .padding(it)
                    .fillMaxSize()
                    .onTap { keyboardController?.hide() },
            ) {

            }
        }
    }
}
