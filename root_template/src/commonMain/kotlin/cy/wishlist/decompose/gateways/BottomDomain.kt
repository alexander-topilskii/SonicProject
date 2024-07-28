package cy.wishlist.decompose.gateways

import com.arkivanov.essenty.instancekeeper.InstanceKeeper
import com.ato.data_storage.firebase_database.user.UsersDao
import com.ato.ui_state.base.UiNavBar
import com.ato.ui_state.wishlist.deeplink.DeepLinkData
import com.ato.ui_state.wishlist.deeplink.DeepLinkData.Companion.EVENTS
import com.ato.ui_state.wishlist.deeplink.DeepLinkData.Companion.FRIENDS
import com.ato.ui_state.wishlist.deeplink.DeepLinkData.Companion.SETTINGS
import com.ato.ui_state.wishlist.deeplink.DeepLinkData.Companion.WISHES
import dev.gitlive.firebase.Firebase
import dev.gitlive.firebase.auth.FirebaseUser
import dev.gitlive.firebase.auth.auth
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.update

internal class BottomDomain(
    private val userDao: UsersDao,
    private val deepLinkData: DeepLinkData?
) : InstanceKeeper.Instance {

    private val selected = MutableStateFlow(0)

    init {
        deepLinkData?.let {
            when (it.getHead()) {
                WISHES -> selected.update { 0 }
                FRIENDS -> selected.update { 1 }
                EVENTS -> selected.update { 2 }
                SETTINGS -> selected.update { 3 }
            }
        }
    }

    fun getState(): Flow<UiBottomState> {
        return Firebase
            .auth
            .authStateChanged
            .combine(selected) { firebaseUser: FirebaseUser?, selectedIndex ->
               return@combine firebaseUser to selectedIndex
            }.flatMapLatest { (firebaseUser: FirebaseUser?, selectedIndex) ->
                val userFlow = userDao.observeUser(firebaseUser?.uid)

                return@flatMapLatest userFlow.map { user -> Triple(firebaseUser, selectedIndex, user) }
            }.map { (firebaseUser, selectedIndex, user) ->

                return@map when {
                    firebaseUser == null ->
                        UiBottomState(
                            firebaseUser = null,
                            user = null,
                            bottomBar = null,
                        )

                    user?.name != null && user.nickname != null ->
                        UiBottomState(
                            firebaseUser = firebaseUser,
                            user = user,
                            bottomBar = UiNavBar(
                                getNavItems(
                                    selectedIndex,
                                    deepLinkData?.getTail()
                                )
                            ),
                        )

                    else ->
                        UiBottomState(
                            firebaseUser = firebaseUser,
                            user = null,
                            bottomBar = null,
                        )
                }
            }
    }

    fun selectPage(index: Int) {
        selected.update { index }
    }
}
