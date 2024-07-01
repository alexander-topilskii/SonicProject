package com.ato.folder.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.ato.folder.component.TemplateComponent
import com.ato.helpers.ResultOf
import com.ato.helpers.display


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
