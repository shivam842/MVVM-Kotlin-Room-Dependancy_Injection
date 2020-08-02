package com.lgdev.mvvvmkotlin.ui.auth

import android.view.View
import androidx.lifecycle.ViewModel
import com.lgdev.mvvvmkotlin.data.repositories.UserRepository
import com.lgdev.mvvvmkotlin.util.ApiException
import com.lgdev.mvvvmkotlin.util.Coroutines

class AuthViewModel : ViewModel() {

    var email: String? = null
    var psw: String? = null
    var authListener: AuthListener? = null

    fun onLoginButtonClick(view: View) {
        authListener?.onStarted()
        if (email.isNullOrEmpty() || psw.isNullOrEmpty()) {
            // failed show error msg in activity..... but how ?
            authListener?.onFailure("Invalid Email or Passeord")
            return
        }

/*        val loginResponse = UserRepository().userLogin(email!!, psw!!)
        authListener?.onSuccess(loginResponse)*/

        //added in coroutine
        Coroutines.main {
            try {
                val authResponse = UserRepository().userLogin(email!!, psw!!)
                authResponse.user?.let {
                    authListener?.onSuccess(it)
                    return@main
                }
                authListener?.onFailure(authResponse.message!!)
            } catch (e: ApiException) {
                authListener?.onFailure(e.message!!)
            }
        }

    }
}