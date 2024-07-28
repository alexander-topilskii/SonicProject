package com.ato.splash.component

import com.ato.splash.ui.SplashUiState
import kotlinx.coroutines.flow.Flow

interface SplashComponent {
    val uiState: Flow<SplashUiState?>

    fun onItemClicked(item: String)
}

