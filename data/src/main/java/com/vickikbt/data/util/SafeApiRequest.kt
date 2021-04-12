package com.vickikbt.data.util

import org.json.JSONException
import org.json.JSONObject
import retrofit2.Response

abstract class SafeApiRequest {

    suspend fun <T : Any> safeApiRequest(call: suspend () -> Response<T>): T {
        val response = call.invoke()
        if (response.isSuccessful) {
            return response.body()!!
        } else {
            val responseErr = response.errorBody()?.string()
            val message = StringBuilder()
            responseErr?.let {
                try {
                    message.append(JSONObject(it).getString("status_message")) //TODO: Revert back to "message"
                } catch (e: JSONException) {
                }
            }
            throw ApiException(message.toString())
        }
    }

}