package com.ato.create_account.di

import com.ato.data_storage.AppContainer

class Di(val appContainer: AppContainer) {

    fun getUserDao() = appContainer.usersDao
}