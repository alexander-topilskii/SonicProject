package com.ato.sonic_presentetion

import androidx.activity.ComponentActivity
import androidx.activity.viewModels
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

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
