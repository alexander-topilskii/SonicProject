package com.ato.bottom

import androidx.lifecycle.ViewModel
import com.ato.sonic_presentetion.Navigation
import com.ato.ui_state.base.UiIconText
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import kotlin.coroutines.CoroutineContext

internal class BottomViewModel(
    override val coroutineContext: CoroutineContext,
    private val repository: BottomRepository,
    private val navigation: Navigation
) : ViewModel(), CoroutineScope {

    val state: StateFlow<UiBottomState?> = repository.getState()
        .stateIn(
            scope = this,
            started = SharingStarted.WhileSubscribed(),
            initialValue = null
        )

    fun onItemClicked(item: UiIconText) {
        val index = state.value?.bottomBar?.items?.indexOf(item)
        index?.let { navigation.openTab(index) }
    }
}
