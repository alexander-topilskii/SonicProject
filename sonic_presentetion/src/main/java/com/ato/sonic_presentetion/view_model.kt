package com.ato.sonic_presentetion

import androidx.activity.ComponentActivity
import androidx.activity.viewModels
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

inline fun <reified VM : ViewModel> ComponentActivity.injectFrom(noinline viewModel: () -> VM): Lazy<VM> =
    viewModels<VM> { ViewModelFactory(viewModel) }

inline fun <reified VM : ViewModel> ComponentActivity.recallFrom(noinline viewModel: () -> VM): Lazy<VM> =
    viewModels<VM> { ViewModelFactory(viewModel) }

@Suppress("UNCHECKED_CAST")
class ViewModelFactory(val viewModel: () -> ViewModel) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return viewModel() as T
    }
}


fun <T> CoroutineScope.createStateFlow(
    defaultValue: T? = null,
    source: suspend () -> Flow<T>
): StateFlow<T?> {
    return MutableStateFlow(defaultValue).also { stateFlow ->
        launch {
            source().collect { data ->
                stateFlow.value = data
            }
        }
    }
}

