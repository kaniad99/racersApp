package com.example.myapplication.teest

import android.util.Log
import com.google.gson.Gson
import com.google.gson.JsonObject
import com.google.gson.reflect.TypeToken
import okhttp3.ResponseBody

class Service {
    private val retrofit = RetrofitClient.getClient()
    private val userApi = retrofit.create(UserApi::class.java)
    private val gson = Gson()

    fun getUsers() {
        val usersResponse = userApi.getUsers()
            .execute()

        val successful = usersResponse.isSuccessful
        val httpStatusCode = usersResponse.code()
        val httpStatusMessage = usersResponse.message()

        val body: JsonObject? = usersResponse.body()

        // If body is empty, then errorBody is filled
        val errorBody: ResponseBody? = usersResponse.errorBody()

        if (errorBody != null) {
            Log.e("Retrofit", "Error body: " + errorBody.string())
        } else {
            Log.d("Retrofit", "IsSuccesful: $successful")
            Log.d("Retrofit", "StatusCode: $httpStatusCode")
            Log.d("Retrofit", "StatusMessage: $httpStatusMessage")
            Log.d("Retrofit", "Body: ${body.toString()}")
        }

        val usersListType = object : TypeToken<List<User>>() {}.type

        val usersList: List<User> = gson.fromJson(
            body!!.getAsJsonObject("_embedded").getAsJsonArray("users"),
            usersListType
        )


        Log.d("Retrofit", usersList.size.toString())
    }

    fun getRacers() {
        val usersResponse = userApi.getRacers()
            .execute()

        val successful = usersResponse.isSuccessful
        val httpStatusCode = usersResponse.code()
        val httpStatusMessage = usersResponse.message()

        val body: JsonObject? = usersResponse.body()

        val errorBody: ResponseBody? = usersResponse.errorBody()

        if (errorBody != null) {
            Log.e("Retrofit", "Error body:" + errorBody.string())
        } else {
            Log.d("Retrofit", "IsSuccessful:$successful")
            Log.d("Retrofit", "StatusCode:$httpStatusCode")
            Log.d("Retrofit", "StatusMessage:$httpStatusMessage")
            Log.d("Retrofit", "Body:${body.toString()}")
        }

        val racersListType = object : TypeToken<List<User>>() {}.type

        val racersList: List<User> = gson.fromJson(
            body!!.getAsJsonObject("_embedded").getAsJsonArray("racers"),
            racersListType
        )
    }
}