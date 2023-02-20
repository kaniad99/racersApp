package com.example.myapplication.RestApi

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {

    private const val BASE_URL = "http://localhost:8080/api/"

    private var sessionId = ""

    fun getSessionId() : String {
        return sessionId
    }

    fun setSessionId(_sessionId: String) {
        sessionId = _sessionId
    }

    fun getClient(login: String, password: String): Retrofit {
        val okHttpClient: OkHttpClient = if (sessionId.isEmpty()) {
            OkHttpClient()
                .newBuilder()
                .addInterceptor(RequestInterceptor)
                .addInterceptor(BasicAuthorizationInterceptor(login, password))
                .build()
        } else {
            OkHttpClient()
                .newBuilder()
                .addInterceptor(RequestInterceptor)
                .build()
        }

        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    fun getClient(): Retrofit {

        val okHttpClient = OkHttpClient()
            .newBuilder()
            .addInterceptor(RequestInterceptor)
            .build()

        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    }


}