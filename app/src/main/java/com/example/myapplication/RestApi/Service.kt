package com.example.myapplication.RestApi

import android.util.Log
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.google.gson.JsonObject
import com.google.gson.reflect.TypeToken
import okhttp3.ResponseBody

class Service {
    private val retrofit = RetrofitClient.getClient()
    private val serviceApi = retrofit.create(ServiceApi::class.java)
    private val gson = Gson()

    fun getUsers() : List<User> {
        val usersResponse = serviceApi.getUsers()
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

        return usersList
    }

    fun getRacers() : List<Racer> {
        val usersResponse = serviceApi.getRacers()
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

        val racersListType = object : TypeToken<List<Racer>>() {}.type

        val racersList: List<Racer> = gson.fromJson(
            body!!.getAsJsonObject("_embedded").getAsJsonArray("racers"),
            racersListType
        )

        return racersList
    }

    fun login(): Boolean {
        val loginResponse = serviceApi.login()
            .execute()

        val successful = loginResponse.isSuccessful
        val httpStatusCode = loginResponse.code()
        val httpStatusMessage = loginResponse.message()

        val errorBody: ResponseBody? = loginResponse.errorBody()

        if (errorBody != null) {
            Log.e("Retrofit", "Error body:" + errorBody.string())
        } else {
            Log.d("Retrofit", "IsSuccessful:$successful")
            Log.d("Retrofit", "StatusCode:$httpStatusCode")
            Log.d("Retrofit", "StatusMessage:$httpStatusMessage")
        }

        return successful
    }

    fun addRacer(racer: Racer) : Boolean {

        val addRacerResponse = serviceApi.addRacer(racer).execute()

        val successful = addRacerResponse.isSuccessful
        val httpStatusCode = addRacerResponse.code()
        val httpStatusMessage = addRacerResponse.message()

        val errorBody: ResponseBody? = addRacerResponse.errorBody()

        if (errorBody != null) {
            Log.e("Retrofit", "Error body:" + errorBody.string())
        } else {
            Log.d("Retrofit", "IsSuccessful:$successful")
            Log.d("Retrofit", "StatusCode:$httpStatusCode")
            Log.d("Retrofit", "StatusMessage:$httpStatusMessage")
        }

        return successful
    }
}