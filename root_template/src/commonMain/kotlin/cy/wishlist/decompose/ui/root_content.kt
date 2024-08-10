package cy.wishlist.decompose.ui

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import com.arkivanov.decompose.extensions.compose.stack.Children
import com.arkivanov.decompose.extensions.compose.stack.animation.fade
import com.arkivanov.decompose.extensions.compose.stack.animation.stackAnimation
import com.ato.create_account.ui.CreateAccountContent
import com.ato.login_root.ui.LoginRootContent
import com.ato.sonic_ui.base.bottom_bar.Display
import com.ato.splash.ui.SplashContent
import cy.wishlist.decompose.component.RootComponent
import cy.wishlist.decompose.ui.theme.AppTheme

@Composable
fun RootContent(component: RootComponent, modifier: Modifier = Modifier) {
    val state by component.uiState.collectAsState(initial = null)
    AppTheme {
        Scaffold(
            bottomBar = {
                state?.bottomBar?.Display(component::selectPage)
            }
        ) { paddings ->
            Children(
                stack = component.stack,
                modifier = modifier.padding(paddings),
                animation = stackAnimation(fade()),
            ) {
                when (val child = it.instance) {
                    is RootComponent.Child.LoginRootChild -> LoginRootContent(child.component)
                    is RootComponent.Child.CreateAccountChild -> CreateAccountContent(child.component)
                    is RootComponent.Child.SplashChild -> SplashContent(child.component)
                }
            }
        }
    }
}