package com.ato.folder.component

import com.ato.folder.ui.TemplateUiState
import com.ato.helpers.ResultOf
import kotlinx.coroutines.flow.Flow

interface TemplateComponent {
    val uiState: Flow<TemplateUiState?>

    fun onItemClicked(item: String)
}

