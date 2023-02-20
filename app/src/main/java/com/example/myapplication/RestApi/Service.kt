package com.example.myapplication.RestApi

import android.util.Log
import com.google.gson.Gson
import com.google.gson.JsonObject
import com.google.gson.reflect.TypeToken
import okhttp3.ResponseBody

class Service {
    private var retrofit = RetrofitClient.getClient()
    private var serviceApi = retrofit.create(ServiceApi::class.java)
    private val gson = Gson()

    fun getUsers() : List<User> {
        val usersResponse = serviceApi.getUsers(RetrofitClient.getSessionId())
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
        val usersResponse = serviceApi.getRacers(RetrofitClient.getSessionId())
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

    fun login(login: String, password: String): Boolean {
        retrofit = RetrofitClient.getClient(login, password)
        serviceApi = retrofit.create(ServiceApi::class.java)

        val loginResponse = serviceApi.login()
            .execute()

        val successful = loginResponse.isSuccessful

        if(successful) {
            RetrofitClient.setSessionId(loginResponse.headers()["Set-Cookie"].toString())
        }

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

        val addRacerResponse = serviceApi.addRacer(RetrofitClient.getSessionId(), racer).execute()

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

    fun deleteRacer(id: Int) : Boolean {
        val addRacerResponse = serviceApi.deleteRacerById(RetrofitClient.getSessionId(), id).execute()

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

    fun editRacer(id: Int, racer: Racer) : Boolean {
        val addRacerResponse = serviceApi.editRacer(RetrofitClient.getSessionId(), id, racer).execute()

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

    fun deleteUser(id: Int) : Boolean {
        val addRacerResponse = serviceApi.deleteUserById(RetrofitClient.getSessionId(), id).execute()

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

    fun editUser(id: Int, user: User) : Boolean {
        val addRacerResponse = serviceApi.editUser(RetrofitClient.getSessionId(), id, user).execute()

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

    fun addUser(user: User) : Boolean {

        val addRacerResponse = serviceApi.addUser(RetrofitClient.getSessionId(), user).execute()

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