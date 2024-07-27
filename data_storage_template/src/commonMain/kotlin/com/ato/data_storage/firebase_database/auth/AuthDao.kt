package com.ato.data_storage.firebase_database.auth

import dev.gitlive.firebase.Firebase
import dev.gitlive.firebase.auth.AuthResult
import dev.gitlive.firebase.auth.FirebaseUser
import dev.gitlive.firebase.auth.auth
import dev.gitlive.firebase.firestore.firestore

class AuthDao {

    suspend fun getCurrentUser(): FirebaseUser? {
        return Firebase.auth.currentUser
    }

    suspend fun login(email: String, password: String): AuthResult {
        return Firebase.auth.signInWithEmailAndPassword(email, password)
    }

    suspend fun signUp(email: String, password: String): AuthResult {
        return Firebase.auth.createUserWithEmailAndPassword(email, password)
    }

    suspend fun logout() {
        try {
            Firebase.auth.signOut()
//            Firebase.firestore.clearPersistence()
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
}