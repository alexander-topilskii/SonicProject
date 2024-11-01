package com.ato.template.component

import com.ato.template.ui.TemplateUiState
import com.ato.helpers.ResultOf
import kotlinx.coroutines.flow.Flow

interface TemplateComponent {
    val uiState: Flow<TemplateUiState?>

    fun onBackClicked()
}

