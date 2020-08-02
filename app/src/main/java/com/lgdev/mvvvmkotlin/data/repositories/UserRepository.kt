package com.lgdev.mvvvmkotlin.data.repositories

import com.lgdev.mvvvmkotlin.data.network.MyApi
import com.lgdev.mvvvmkotlin.data.network.responses.AuthResponse
import com.lgdev.mvvvmkotlin.data.network.responses.SafeApiResponse
import retrofit2.Response

class UserRepository : SafeApiResponse() {

    suspend fun userLogin(email: String, psw: String): AuthResponse {
        return apiRequest { MyApi().userLogin(email, psw) }
    }
}