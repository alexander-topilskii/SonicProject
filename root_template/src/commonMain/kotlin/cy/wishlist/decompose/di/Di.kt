package cy.wishlist.decompose.di

import com.ato.data_storage.AppContainer

 class Di(private val appContainer: AppContainer) {

    fun getUserDao() = appContainer.usersDao
}