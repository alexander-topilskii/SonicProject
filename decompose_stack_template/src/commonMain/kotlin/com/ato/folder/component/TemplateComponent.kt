package com.ato.folder.component

import com.arkivanov.decompose.Child
import com.arkivanov.decompose.router.stack.ChildStack
import com.arkivanov.decompose.value.Value
import com.ato.folder.ui.TemplateUiState
import kotlinx.coroutines.flow.Flow
import kotlinx.serialization.Serializable

interface TemplateComponent {
    val uiState: Flow<TemplateUiState?>
    val stack: Value<ChildStack<*, Child>>

    fun onItemClicked(item: String)

    sealed class Child {
//        class FollowingListChild(val component: FollowingListComponent) : Child()
    }

    @Serializable
    sealed interface Config {
//        @Serializable
//        data object FollowingList : Config
    }
}

