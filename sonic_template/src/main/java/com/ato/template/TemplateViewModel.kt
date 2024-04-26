package com.ato.template

import androidx.lifecycle.ViewModel
import com.ato.sonic_presentetion.Navigation
import com.ato.ui_state.mood.UiMoodAndEnergyItem
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import kotlin.coroutines.CoroutineContext

internal class TemplateViewModel(
    override val coroutineContext: CoroutineContext,
    private val repository: TemplateRepository,
    private val navigation: Navigation
) : ViewModel(), CoroutineScope {

    val state: StateFlow<UiTemplateState?> = repository.getState()
        .stateIn(
            scope = this,
            started = SharingStarted.WhileSubscribed(),
            initialValue = null
        )

    fun onClick(uiMoodAndEnergyItem: UiMoodAndEnergyItem) {
//        navigation.forwardMoodEnergyItem(uiMoodAndEnergyItem.id)
    }
}
