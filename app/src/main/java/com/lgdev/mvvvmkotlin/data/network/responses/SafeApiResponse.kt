package com.lgdev.mvvvmkotlin.data.network.responses

import com.lgdev.mvvvmkotlin.util.ApiException
import org.json.JSONObject
import retrofit2.Response
import java.lang.Exception

abstract class SafeApiResponse {

    suspend fun<T: Any> apiRequest(call : suspend () -> Response<T>) : T{
        val response =  call.invoke();

        if(response.isSuccessful){
            return response.body()!!
        } else{
            val error = response.errorBody()?.toString()
            val message  = StringBuilder()

            error?.let {
                try {
                    message.append(JSONObject(it).getString("message"))
                } catch (e : Exception){

                }
                message.append("\n ")
            }
            message.append("Error Code: ${response.code()}")

            throw ApiException(message.toString())
        }
    }
}