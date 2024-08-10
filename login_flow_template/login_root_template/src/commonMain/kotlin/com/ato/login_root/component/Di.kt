package com.ato.login_root.component

import com.ato.data_storage.AppContainer

internal class Di(
    private val appContainer: AppContainer,
) {

    //fun get() = appContainer.dataBase

    fun getUserDao() = appContainer.usersDao
    fun getAuthDao() = appContainer.authDao
}
