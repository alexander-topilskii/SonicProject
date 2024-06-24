package com.ato.helpers

import com.arkivanov.decompose.Child
import com.arkivanov.decompose.GenericComponentContext
import com.arkivanov.decompose.router.children.ChildNavState.Status
import com.arkivanov.decompose.router.children.NavState
import com.arkivanov.decompose.router.children.NavigationSource
import com.arkivanov.decompose.router.children.SimpleChildNavState
import com.arkivanov.decompose.router.children.children
import com.arkivanov.decompose.router.stack.ChildStack
import com.arkivanov.decompose.router.stack.StackNavigation
import com.arkivanov.decompose.value.Value
import com.arkivanov.essenty.statekeeper.SerializableContainer
import com.arkivanov.essenty.statekeeper.consumeRequired
import kotlinx.serialization.KSerializer
import kotlinx.serialization.builtins.ListSerializer

fun <Ctx: GenericComponentContext<Ctx>, C : Any, T : Any> Ctx.myChildStack(
    source: NavigationSource<StackNavigation.Event<C>>,
    serializer: KSerializer<C>?,
    initialStack: () -> List<C>,
    key: String = "DefaultChildStack",
    handleBackButton: Boolean = false,
    childFactory: (configuration: C, Ctx) -> T,
): Value<MyChildStack<C, T>> =
    myChildStack(
        source = source,
        saveStack = { stack ->
            if (serializer != null) {
                SerializableContainer(value = stack, strategy = ListSerializer(serializer))
            } else {
                null
            }
        },
        restoreStack = { container ->
            if (serializer != null) {
                container.consumeRequired(strategy = ListSerializer(serializer))
            } else {
                null
            }
        },
        initialStack = initialStack,
        key = key,
        handleBackButton = handleBackButton,
        childFactory = childFactory,
    )

fun <Ctx : GenericComponentContext<Ctx>, C : Any, T : Any> Ctx.myChildStack(
    source: NavigationSource<StackNavigation.Event<C>>,
    initialStack: () -> List<C>,
    saveStack: (List<C>) -> SerializableContainer?,
    restoreStack: (SerializableContainer) -> List<C>?,
    key: String = "DefaultChildStack",
    handleBackButton: Boolean = false,
    childFactory: (configuration: C, Ctx) -> T,
): Value<MyChildStack<C, T>> =
    children(
        source = source,
        key = key,
        initialState = { StackNavState(configurations = initialStack()) },
        saveState = { saveStack(it.configurations) },
        restoreState = { container -> StackNavState(configurations = restoreStack(container) ?: initialStack()) },
        navTransformer = { state, event -> StackNavState(configurations = event.transformer(state.configurations)) },
        stateMapper = { _, children ->
            @Suppress("UNCHECKED_CAST")
            val createdChildren = children as List<Child.Created<C, T>>
            if (createdChildren.isEmpty()) {
                MyChildStack(
                    active = null,
                    backStack = createdChildren.dropLast(1),
                )
            } else {
                MyChildStack(
                    active = createdChildren.last(),
                    backStack = createdChildren.dropLast(1),
                )
            }
        },
        onEventComplete = { event, newState, oldState ->
            event.onComplete(newState.configurations, oldState.configurations)
        },
        backTransformer = { state ->
            if (handleBackButton && (state.configurations.size > 1)) {
                { StackNavState(configurations = state.configurations.dropLast(1)) }
            } else {
                null
            }
        },
        childFactory = childFactory,
    )

private data class StackNavState<out C : Any>(
    val configurations: List<C>,
) : NavState<C> {

    override val children: List<SimpleChildNavState<C>> =
        configurations.mapIndexed { index, configuration ->
            SimpleChildNavState(
                configuration = configuration,
                status = if (index == configurations.lastIndex) Status.RESUMED else Status.CREATED,
            )
        }
}

data class MyChildStack<out C : Any, out T : Any>(
    val active: Child.Created<C, T>?,
    val backStack: List<Child.Created<C, T>> = emptyList(),
) {

    /**
     * Creates [ChildStack] with only one child with the specified [configuration] and [instance].
     */
    constructor(configuration: C, instance: T) : this(
        active = Child.Created(
            configuration = configuration,
            instance = instance
        ),
    )

    /**
     * Returns the full stack of component configurations, ordered from tail to head.
     */
    val items: List<Child.Created<C, T>?> =
        GettingList(size = backStack.size + 1) { index ->
            backStack.getOrNull(index) ?: active
        }
}

internal class GettingList<out T>(
    override val size: Int,
    private val get: (Int) -> T,
) : AbstractList<T>() {

    override fun get(index: Int): T =
        get.invoke(index)
}