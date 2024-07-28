package cy.wishlist.decompose.gateways

import com.ato.data_storage.firebase_database.user.User
import com.ato.data_storage.firebase_database.user.WishlistUser
import com.ato.ui_state.base.UiNavBar
import dev.gitlive.firebase.auth.FirebaseUser

data class UiBottomState(
    val firebaseUser: FirebaseUser?,
    val user: User?,
    val bottomBar: UiNavBar?,
)