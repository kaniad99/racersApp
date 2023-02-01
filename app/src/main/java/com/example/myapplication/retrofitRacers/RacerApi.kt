package com.example.myapplication.retrofitRacers

import com.example.myapplication.retrofitExample.QuoteList
import retrofit2.Response
import retrofit2.http.GET

interface RacerApi {
    @GET("/racers")
    suspend fun getRacers() : Response<String>
}