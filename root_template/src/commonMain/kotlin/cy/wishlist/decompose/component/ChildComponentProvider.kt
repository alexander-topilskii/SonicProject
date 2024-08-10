package cy.wishlist.decompose.component

import com.arkivanov.decompose.ComponentContext
import com.ato.create_account.component.CreateAccountComponent
import com.ato.create_account.component.DefaultCreateAccountComponent
import com.ato.data_storage.AppContainer
import com.ato.login_root.component.DefaultLoginRootComponent
import com.ato.login_root.component.LoginRootComponent
import com.ato.splash.component.DefaultSplashComponent
import com.ato.splash.component.SplashComponent
import cy.wishlist.decompose.component.DefaultRootComponent.Config

internal class ChildComponentProvider(
    private val appContainer: AppContainer,
) {

    fun child(config: Config, componentContext: ComponentContext): RootComponent.Child =
        when (config) {
            is Config.LoginRoot -> RootComponent.Child.LoginRootChild(
                loginRootComponent(
                    componentContext,
                    config
                )
            )

            is Config.CreateAccount -> RootComponent.Child.CreateAccountChild(
                createAccountComponent(
                    componentContext,
                    config
                )
            )

            is Config.Splash -> RootComponent.Child.SplashChild(
                splashComponent(
                    componentContext,
                    config
                )
            )
        }

    private fun loginRootComponent(
        componentContext: ComponentContext,
        config: Config.LoginRoot
    ): LoginRootComponent = DefaultLoginRootComponent(
        componentContext = componentContext,
        appContainer = appContainer,
    )

    private fun createAccountComponent(
        componentContext: ComponentContext,
        config: Config.CreateAccount
    ): CreateAccountComponent = DefaultCreateAccountComponent(
        componentContext = componentContext,
        appContainer = appContainer,
    )

    private fun splashComponent(
        componentContext: ComponentContext,
        config: Config.Splash
    ): SplashComponent = DefaultSplashComponent(
        componentContext = componentContext,
        appContainer = appContainer,
    )
}