package com.lgdev.mvvvmkotlin.data.network.responses

import com.lgdev.mvvvmkotlin.data.db.entities.User

data class AuthResponse(
    val isSuccessful: Boolean?,
    val message: String?,
    val user: User?
)