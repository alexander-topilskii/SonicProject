package cy.wishlist.decompose.component

import com.arkivanov.decompose.router.stack.ChildStack
import com.arkivanov.decompose.value.Value
import com.ato.create_account.component.CreateAccountComponent
import com.ato.login_root.component.LoginRootComponent
import com.ato.splash.component.SplashComponent
import cy.wishlist.decompose.gateways.UiBottomState
import kotlinx.coroutines.flow.StateFlow

interface RootComponent {

    val stack: Value<ChildStack<*, Child>>

    fun selectPage(index: Int)

    // Defines all possible child components
    sealed class Child {
        class LoginRootChild(val component: LoginRootComponent) : Child()
        class CreateAccountChild(val component: CreateAccountComponent) : Child()
        class SplashChild(val component: SplashComponent) : Child()
    }

    val uiState: StateFlow<UiBottomState?>
}