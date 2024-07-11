package com.ato.folder.component

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.router.stack.ChildStack
import com.arkivanov.decompose.router.stack.StackNavigation
import com.arkivanov.decompose.router.stack.childStack
import com.arkivanov.decompose.router.stack.push
import com.arkivanov.decompose.value.Value
import com.arkivanov.essenty.instancekeeper.getOrCreate
import com.ato.folder.di.Di
import com.ato.folder.gateways.TemplateGateways
import com.ato.folder.ui.TemplateUiState
import com.ato.helpers.componentCoroutineScope
import com.ato.helpers.createNotNullStateFlow
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import kotlinx.serialization.builtins.serializer

class DefaultTemplateComponent(
    private val componentContext: ComponentContext,
    private val item: String,
    private val di: Di = Di()
) : TemplateComponent, ComponentContext by componentContext,
    CoroutineScope by componentContext.componentCoroutineScope() {

    private companion object {
        private const val KEY_STATE = "Template"
    }

    private val navigation = StackNavigation<TemplateComponent.Config>()
    private val childComponentProvider = ChildComponentProvider()
    override val stack: Value<ChildStack<*, TemplateComponent.Child>> =
        childStack(
            source = navigation,
            handleBackButton = true,
            serializer = TemplateComponent.Config.serializer(),
            initialConfiguration = TODO(), //TemplateComponent.Config.FollowingList,
            childFactory = childComponentProvider::child,
        )
    private val handler: TemplateGateways = instanceKeeper.getOrCreate(KEY_STATE) {
        TemplateGateways(
            componentContext = componentContext,
            initialState = stateKeeper.consume(
                key = KEY_STATE,
                strategy = String.serializer()
            )
        )
    }

    override val uiState: Flow<TemplateUiState?> =
        createNotNullStateFlow(null) {
            handler.getData()
        }

    override fun onItemClicked(item: String) {
        launch {

        }
    }
}


