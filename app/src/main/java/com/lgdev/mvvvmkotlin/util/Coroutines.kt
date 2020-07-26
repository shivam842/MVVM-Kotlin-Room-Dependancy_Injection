package com.lgdev.mvvvmkotlin.util

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

// object is same as static in java
object Coroutines {

    //Unit is same as main in java
    //This will be executed in the main thread
    fun main(work: suspend (() -> Unit)) =
        CoroutineScope(Dispatchers.Main).launch {
            work()
        }
}