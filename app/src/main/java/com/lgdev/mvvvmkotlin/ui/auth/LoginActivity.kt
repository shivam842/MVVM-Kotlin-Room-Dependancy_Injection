package com.lgdev.mvvvmkotlin.ui.auth

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import com.lgdev.mvvvmkotlin.R
import com.lgdev.mvvvmkotlin.data.db.entities.User
import com.lgdev.mvvvmkotlin.databinding.ActivityLoginBinding
import com.lgdev.mvvvmkotlin.util.hide
import com.lgdev.mvvvmkotlin.util.show
import com.lgdev.mvvvmkotlin.util.toast
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity(),
    AuthListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivityLoginBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_login)

        val viewModel = ViewModelProviders.of(this).get(AuthViewModel::class.java)

        binding.viewmodel = viewModel
        viewModel.authListener = this

    }

    override fun onStarted() {
        progress_bar.show()
        toast("Login Started")
    }

    override fun onSuccess(user: User?) {
        progress_bar.hide()
        toast("${user?.name} is Logged In")
    }

    override fun onFailure(msg: String) {
        progress_bar.hide()
        toast(msg)
    }
}