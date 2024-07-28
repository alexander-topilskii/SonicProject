package cy.wishlist.decompose.component

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.router.stack.ChildStack
import com.arkivanov.decompose.router.stack.StackNavigation
import com.arkivanov.decompose.router.stack.childStack
import com.arkivanov.decompose.router.stack.pushToFront
import com.arkivanov.decompose.router.stack.replaceAll
import com.arkivanov.decompose.value.Value
import com.arkivanov.essenty.instancekeeper.getOrCreate
import com.ato.data_storage.AppContainer
import com.ato.helpers.componentCoroutineScope
import com.ato.helpers.createStateFlow
import com.ato.ui_state.wishlist.deeplink.DeepLinkData
import cy.wishlist.decompose.di.Di
import cy.wishlist.decompose.gateways.BottomDomain
import cy.wishlist.decompose.gateways.UiBottomState
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.withContext
import kotlinx.serialization.Serializable

class DefaultRootComponent(
    componentContext: Any,
    appContainer: AppContainer,
    private val deepLinkData: DeepLinkData?,
    private val di: Di = Di(appContainer)
) : RootComponent, ComponentContext by componentContext as ComponentContext,
    CoroutineScope by (componentContext as ComponentContext).componentCoroutineScope() {

    private companion object {
        private const val KEY_STATE = "STATE"
    }

    private val navigation = StackNavigation<Config>()
    private val childComponentProvider = ChildComponentProvider(appContainer)
    override val stack: Value<ChildStack<*, RootComponent.Child>> =
        childStack(
            source = navigation,
            handleBackButton = false,
            serializer = Config.serializer(),
            initialConfiguration = Config.Splash,
            childFactory = childComponentProvider::child,
        )

    private val domain: BottomDomain = instanceKeeper.getOrCreate(KEY_STATE) {
        BottomDomain(
            userDao = di.getUserDao(),
            deepLinkData = deepLinkData
        )
    }
    override val uiState = createStateFlow(null) {
        domain.getState()
            .onEach { currentState ->
                withContext(Dispatchers.Main) {
                    when {
                        currentState.firebaseUser == null -> navigation.replaceAll(Config.LoginRoot)
                        currentState.user == null -> navigation.replaceAll(Config.CreateAccount)
                        else -> getCurrentPageConfig(currentState)?.let {
                            navigation.pushToFront(it)
                        }
                    }
                }
            }
    }

    private fun getCurrentPageConfig(it: UiBottomState) =
        it.bottomBar?.items?.find { it.isSelected }?.meta as Config?

    override fun selectPage(index: Int) {
        domain.selectPage(index)
    }

    @Serializable
    internal sealed interface Config {
        // Login
        @Serializable
        data object LoginRoot : Config

        @Serializable
        data object CreateAccount : Config

        @Serializable
        data object Splash : Config
    }
}