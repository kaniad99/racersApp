package com.example.myapplication.RestApi

import com.google.gson.JsonObject
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface ServiceApi {
    @GET("users")
    fun getUsers(): Call<JsonObject>

    @GET("racers")
    fun getRacers(): Call<JsonObject>

    @GET(".")
    fun login(): Call<Void>

    @POST("racers")
    fun addRacer(@Body racer: Racer): Call<Void>

    @DELETE("racers/{racerId}")
    fun deleteRacerById(@Path("racerId") racerId: Int): Call<Void>

}