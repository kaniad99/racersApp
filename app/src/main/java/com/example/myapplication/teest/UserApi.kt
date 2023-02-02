package com.example.myapplication.teest

import com.google.gson.JsonObject
import retrofit2.Call
import retrofit2.http.GET

interface UserApi {
    @GET("users")
    fun getUsers(): Call<JsonObject>

    @GET("racers")
    fun getRacers(): Call<JsonObject>


}