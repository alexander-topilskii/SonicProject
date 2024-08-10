package com.ato.create_account.gateways

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.essenty.instancekeeper.InstanceKeeper
import com.ato.create_account.ui.CreateAccountUiState
import com.ato.data_storage.firebase_database.user.UsersDao
import com.ato.helpers.componentCoroutineScope
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update

internal class CreateAccountGateways(
    componentContext: ComponentContext,
    val userDao: UsersDao
) : InstanceKeeper.Instance, CoroutineScope by componentContext.componentCoroutineScope() {

    private val mutableStateFlow: MutableStateFlow<CreateAccountUiState> = getInitState()

    fun getData(): Flow<CreateAccountUiState> {
        return mutableStateFlow
    }

    fun changeName(name: String) {
        mutableStateFlow.update {
            it.copy(
                userName = it.userName.copy(
                    inputText = name,
                    errorText = null
                )
            )
        }
    }


    fun changeNick(nick: String) {
        mutableStateFlow.update {
            it.copy(
                userNick = it.userNick.copy(
                    inputText = nick.lowercase(),
                    errorText = null
                )
            )
        }
    }

    suspend fun createAccount() {
        val data = mutableStateFlow.value
        val name: String = data.userName.inputText
        val nick: String = data.userNick.inputText

        if (!checkNameEmpty(name) || !checkNickEmpty(nick) || !checkNickShort(nick)) {
            return
        }

        val existUser = userDao.checkNickName(nick)
        if (existUser == null) {
            userDao.createUser(name, nick,)
        } else {
            mutableStateFlow.nickTaken()
        }
    }

    private fun checkNameEmpty(name: String): Boolean {
        if (name.isEmpty()) {
            mutableStateFlow.nameEmpty()
            return false
        }
        return true
    }

    private fun checkNickEmpty(nick: String): Boolean {
        if (nick.isEmpty()) {
            mutableStateFlow.nickEmpty()
            return false
        }
        return true
    }

    private fun checkNickShort(nick: String): Boolean {
        val tooShort = nick.length < 3
        val tooLong = nick.length > 21
        val notValid = !isValidString(nick)

        when {
            tooShort -> mutableStateFlow.nickShort()
            tooLong -> mutableStateFlow.nickLong()
            notValid -> mutableStateFlow.nickContainsUnavailableLetters()
        }

        return !tooShort || !tooLong || !notValid
    }

    private fun isValidString(input: String): Boolean {
        val regex = "^[\\w-]+$".toRegex()
        return input.matches(regex)
    }
}
