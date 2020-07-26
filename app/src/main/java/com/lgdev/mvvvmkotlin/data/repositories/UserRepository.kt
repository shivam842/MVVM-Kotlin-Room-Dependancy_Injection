package com.lgdev.mvvvmkotlin.data.repositories

import com.lgdev.mvvvmkotlin.data.network.MyApi
import com.lgdev.mvvvmkotlin.data.network.responses.AuthResponse
import retrofit2.Response

class UserRepository {

    suspend fun userLogin(email: String, psw: String): Response<AuthResponse> {
        return MyApi().userLogin(email, psw)
    }
}