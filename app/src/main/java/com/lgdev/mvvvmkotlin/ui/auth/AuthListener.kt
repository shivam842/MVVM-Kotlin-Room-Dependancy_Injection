package com.lgdev.mvvvmkotlin.ui.auth

import com.lgdev.mvvvmkotlin.data.db.entities.User

interface AuthListener {
    fun onStarted()
    fun onSuccess(user: User?)
    fun onFailure(msg : String)
}