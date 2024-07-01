package com.ato.folder.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.arkivanov.decompose.extensions.compose.subscribeAsState
import com.ato.folder.component.TemplateComponent
import com.ato.helpers.ResultOf
import com.ato.helpers.display
import com.ato.ui_state.base.loading.LoadingAtoms


@Composable
fun TemplateContent(
    component: TemplateComponent,
    modifier: Modifier = Modifier
) {
    val model by component.uiState.collectAsState(ResultOf.Loading())

    Box(
        modifier = modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        model.display(
            onLoading = {
                Text("Display Loading")
                LoadingAtoms(
                    colors = listOf(
                        MaterialTheme.colorScheme.primary,
                        MaterialTheme.colorScheme.secondary
                    ),
                    modifier = Modifier
                        .aspectRatio(1f)
                        .fillMaxSize()
                        .padding(16.dp)
                )
            },
            onError = { _, _ ->
                Text("Error")
            },
            onSuccess = { data: TemplateUiState?, _ ->
                Text("Display $data")
            },
            onSuccessEmpty = {
                Text("There is noting")
            }
        )
    }
}
