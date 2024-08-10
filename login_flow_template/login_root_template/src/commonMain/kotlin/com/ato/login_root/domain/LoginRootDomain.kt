package com.ato.login_root.domain

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.essenty.instancekeeper.InstanceKeeper
import com.ato.data_storage.firebase_database.auth.AuthDao
import com.ato.data_storage.firebase_database.user.UsersDao
import com.ato.helpers.componentCoroutineScope
import com.ato.login_root.ui.LoginRootUiState
import dev.gitlive.firebase.auth.FirebaseAuthEmailException
import dev.gitlive.firebase.auth.FirebaseAuthInvalidCredentialsException
import dev.gitlive.firebase.auth.FirebaseAuthInvalidUserException
import dev.gitlive.firebase.auth.FirebaseAuthUserCollisionException
import dev.gitlive.firebase.auth.FirebaseAuthWeakPasswordException
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow

internal class LoginRootDomain(
    componentContext: ComponentContext,
    private val usersDao: UsersDao,
    private val authDao: AuthDao,
) : InstanceKeeper.Instance, CoroutineScope by componentContext.componentCoroutineScope() {

    private val state: MutableStateFlow<LoginRootUiState> = getInitState()

    fun getData(): Flow<LoginRootUiState> {
        return state
    }

    suspend fun login() {
        state.loginProcess(true)

        val data = state.value
        val email: String = data.email.inputText
        val password: String = data.password.inputText

        if (!checkEmail(email) || !checkPassword(password)) {
            state.loginProcess(false)

            return
        }

        try {
            authDao.login(email, password)
        } catch (e: Exception) {
            handleError(e)
        } finally {
            state.loginProcess(false)
        }
    }

    fun setEmail(newEmail: String) {
        state.updateEmail(newEmail)
    }

    fun setPassword(newPassword: String) {
        state.updatePassword(newPassword)

    }

    fun setRepeatPassword(newRepeatPassword: String) {
        state.newRepeatPassword(newRepeatPassword)
    }

    suspend fun signUp() {
        state.signUpProcess(true)

        val data = state.value
        val email: String = data.email.inputText
        val password: String = data.password.inputText
        val repeatPassword: String? = data.repeatPassword?.inputText

        if (
            !checkEmail(email) ||
            !checkPassword(password) ||
            !checkRepeatPassword(repeatPassword) ||
            !checkBothPasswords(password, repeatPassword)
        ) {
            state.signUpProcess(false)
            return
        }

        try {
            authDao.signUp(email, password)
        } catch (e: Exception) {
            handleError(e)
        } finally {
            state.signUpProcess(false)
        }
    }

    private fun handleError(e: Exception) {
        e.printStackTrace()
        when (e) {
            is FirebaseAuthEmailException -> {}
            is FirebaseAuthUserCollisionException -> state.emailInUse()
            is FirebaseAuthInvalidUserException -> state.invalidUser()
            is FirebaseAuthWeakPasswordException -> state.passwordTooWeak()
            // должен быть последним
            is FirebaseAuthInvalidCredentialsException -> state.emailInvalid()
            else -> {

            }
        }
    }

    private fun checkRepeatPassword(repeatPassword: String?): Boolean {
        if (repeatPassword.isNullOrEmpty()) {
            state.setRepeatPasswordEmpty()
            return false
        }
        state.setRepeatPasswordNormalState()
        return true
    }


    private fun checkBothPasswords(password: String?, repeatPassword: String?): Boolean {
        if (password != repeatPassword) {
            state.setPasswordAreDifferent()
            return false
        }
        state.setPasswordNormalState()
        state.setRepeatPasswordNormalState()
        return true
    }

    private inline fun checkEmail(email: String): Boolean {
        if (email.isEmpty()) {
            state.setEmailEmpty()
            return false
        }
        state.setEmailNormalState()
        return true
    }

    private inline fun checkPassword(password: String): Boolean {
        if (password.isEmpty()) {
            state.setPasswordEmpty()
            return false
        }
        state.setPasswordNormalState()
        return true
    }
}
