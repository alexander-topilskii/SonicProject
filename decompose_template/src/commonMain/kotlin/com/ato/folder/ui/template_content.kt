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


@Composable
fun TemplateContent(
    component: TemplateComponent,
    modifier: Modifier = Modifier
) {
    val model by component.uiState.collectAsState(null)

    Box(
        modifier = modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text("Template Display $model")
    }
}
