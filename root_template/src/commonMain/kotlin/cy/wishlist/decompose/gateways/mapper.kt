package cy.wishlist.decompose.gateways

import com.ato.ui_state.base.NavBarItem
import com.ato.ui_state.wishlist.deeplink.DeepLinkData


private fun select(
    selectedIndex: Int,
    index: Int,
    navBarItem: NavBarItem
): NavBarItem {
    return if (selectedIndex == index) {
        navBarItem.copy(isSelected = true)
    } else {
        navBarItem.copy(isSelected = false)
    }
}

internal fun getNavItems(selectedIndex: Int, deepLinkData: DeepLinkData?): List<NavBarItem> {
    return emptyList<NavBarItem>(
//        NavBarItem(
//            icon = UiIcon(Icons.Filled.Home),
//            meta = DefaultRootComponent.Config.WishRoot(deepLinkData)
//        ),
//        NavBarItem(
//            icon = UiIcon(Icons.Filled.Person),
//            meta = DefaultRootComponent.Config.FriendsRoot(deepLinkData)
//        ),
//        NavBarItem(
//            icon = UiIcon(Icons.Filled.Favorite),
//            meta = DefaultRootComponent.Config.EventsRoot(deepLinkData)
//        ),
//        NavBarItem(
//            icon = UiIcon(Icons.Filled.Settings),
//            meta = DefaultRootComponent.Config.Settings(deepLinkData)
//        )
    ).mapIndexed { index, navBarItem ->
        select(selectedIndex, index, navBarItem)
    }
}