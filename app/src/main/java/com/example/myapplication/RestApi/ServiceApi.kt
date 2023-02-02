package com.example.myapplication.RestApi

import com.google.gson.JsonObject
import retrofit2.Call
import retrofit2.http.GET

interface ServiceApi {
    @GET("users")
    fun getUsers(): Call<JsonObject>

    @GET("racers")
    fun getRacers(): Call<JsonObject>

    @GET(".")
    fun login(): Call<Void>

}