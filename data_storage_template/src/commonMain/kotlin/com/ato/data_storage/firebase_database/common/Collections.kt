package com.ato.data_storage.firebase_database.common

import dev.gitlive.firebase.firestore.DocumentSnapshot

object Collections {
    const val USERS_COLLECTION = "users"
}

fun <T> List<DocumentSnapshot>.mapCatching(action: DocumentSnapshot.() -> T): List<T> {
    return this.mapNotNull {
        it.catchMapping {
            action.invoke(this)
        }
    }
}

fun <T> DocumentSnapshot.catchMapping(action: DocumentSnapshot.() -> T) = try {
    action.invoke(this)
} catch (e: Exception) {
    e.printStackTrace()
    null
}