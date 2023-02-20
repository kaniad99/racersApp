package com.example.myapplication.RestApi

import com.google.gson.JsonObject
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path

interface ServiceApi {
    @GET("users")
    fun getUsers(@Header("Cookie") cookie: String): Call<JsonObject>

    @GET("racers")
    fun getRacers(@Header("Cookie") cookie: String): Call<JsonObject>

    @GET(".")
    fun login(): Call<Void>

    @POST("racers")
    fun addRacer(@Header("Cookie") cookie: String, @Body racer: Racer): Call<Void>

    @DELETE("racers/{racerId}")
    fun deleteRacerById(@Header("Cookie") cookie: String, @Path("racerId") racerId: Int): Call<Void>

    @PUT("racers/{racerId}/profile")
    fun editRacer(@Header("Cookie") cookie: String, @Path("racerId") racerId: Int, @Body racer: Racer): Call<Void>

    @POST("users")
    fun addUser(@Header("Cookie") cookie: String, @Body user: User): Call<Void>

    @DELETE("users/{userId}")
    fun deleteUserById(@Header("Cookie") cookie: String, @Path("userId") userId: Int): Call<Void>

    @PUT("users/{userId}/profile")
    fun editUser(@Header("Cookie") cookie: String, @Path("userId") racerId: Int, @Body user: User): Call<Void>


}