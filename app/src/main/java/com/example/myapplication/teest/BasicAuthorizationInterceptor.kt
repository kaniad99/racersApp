package com.example.myapplication.teest

import okhttp3.Credentials
import okhttp3.Interceptor
import okhttp3.Response

class BasicAuthorizationInterceptor(username: String, password: String) : Interceptor {
    private var credentials: String = Credentials.basic(username, password)

    override fun intercept(chain: Interceptor.Chain): Response {
        val requestWithHeader = chain.request()
            .newBuilder()
            .header("Authorization", credentials)
            .build()

        return chain.proceed(requestWithHeader)
    }



}