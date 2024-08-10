package com.ato.data_storage.firebase_database.user

import kotlinx.serialization.Serializable

@Serializable
data class User(
    var id: String? = null,
    var authId: String? = null, // Firebase authId
    var nickname: String? = null,
    var name: String? = null,
    var email: String? = null,
)