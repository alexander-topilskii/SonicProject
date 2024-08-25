package com.ato.data_storage.firebase_database.user

import com.ato.data_storage.firebase_database.common.Collections.USERS_COLLECTION
import com.ato.data_storage.firebase_database.common.mapCatching
import dev.gitlive.firebase.Firebase
import dev.gitlive.firebase.auth.auth
import dev.gitlive.firebase.firestore.FieldPath
import dev.gitlive.firebase.firestore.firestore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.map

class UsersDao {
    suspend fun observeUser(authId: String?): Flow<User?> {
        if (authId == null) return flowOf(null)

        return FirebaseWrapper.firestore.collection(USERS_COLLECTION).where {
            User::id.name equalTo authId
        }

            .snapshots.map { response ->
                response.documents.mapCatching {
                    data<User>().copy(
                        id = id
                    )
                }.firstOrNull()
            }
    }

    suspend fun getCurrentUser(): User? {
        val currentUser = Firebase.auth.currentUser ?: return null

        val userResponse = FirebaseWrapper.firestore.collection(USERS_COLLECTION)
            .where {
                User::id.name equalTo currentUser.uid
            }.get()

        return userResponse.documents.mapCatching {
            data<User>().copy(
                id = id
            )
        }.firstOrNull()
    }

    suspend fun createUser(
        name: String?,
        nickname: String
    ) {
        val currentUser = Firebase.auth.currentUser ?: throw IllegalStateException()

        val user = User(
            authId = currentUser.uid,
            name = name,
            email = currentUser.email,
            nickname = nickname.lowercase()
        )

        FirebaseWrapper.firestore
            .collection(USERS_COLLECTION)
            .add(user)
    }

    suspend fun getUserById(userDocId: String?): User? {
        userDocId ?: return null

        val userResponse = FirebaseWrapper.firestore
            .collection(USERS_COLLECTION)
            .document(userDocId)
            .get()

        return userResponse.data<User>().copy(
            id = userResponse.id
        )
    }

    suspend fun getAllUsers(): List<User> {
        val response = FirebaseWrapper.firestore
            .collection(USERS_COLLECTION)
            .get()

        return response.documents.mapCatching {
            data<User>().copy(
                id = id
            )
        }
    }

    suspend fun search(promt: String): List<User> {
        val response1 = FirebaseWrapper.firestore
            .collection(USERS_COLLECTION)
            .where { User::nickname.name greaterThanOrEqualTo promt }
            .where { User::nickname.name lessThanOrEqualTo (promt + '\uf8ff') }
            .get()

        val response2 = FirebaseWrapper.firestore
            .collection(USERS_COLLECTION)
            .where { User::name.name greaterThanOrEqualTo promt }
            .where { User::name.name lessThanOrEqualTo (promt + '\uf8ff') }
            .get()

        val combinedDocuments = response1.documents + response2.documents

        return combinedDocuments.mapCatching {
            data<User>().copy(
                id = id
            )
        }
    }

    suspend fun getAllUsers(userIds: List<String>): List<User> {
        val response = FirebaseWrapper.firestore
            .collection(USERS_COLLECTION)
            .where { FieldPath.documentId inArray userIds }
            .get()

        return response.documents.mapCatching {
            data<User>().copy(
                id = id
            )
        }
    }
}
