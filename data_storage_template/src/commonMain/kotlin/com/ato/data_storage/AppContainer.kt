package com.ato.data_storage

import com.ato.data_storage.firebase_database.auth.AuthDao
import com.ato.data_storage.firebase_database.user.UsersDao
import com.ato.ui_state.wishlist.deeplink.DeeplinkExecutor

class AppContainer(
    private val factory: Factory,
    val deeplinkExecutor: DeeplinkExecutor,
) {
    var isDebug: Boolean = false
    var version: Int = 0

    fun putInfo(isDebug: Boolean, version: Int) {
        this.isDebug = isDebug
        this.version = version
    }

    val dataBase: TemplateDataBase = factory.createRoomDatabase()

    val authDao: AuthDao by lazy { AuthDao() }
    val usersDao: UsersDao by lazy { UsersDao() }
}

val dbFileName = "Template_database_dev"
