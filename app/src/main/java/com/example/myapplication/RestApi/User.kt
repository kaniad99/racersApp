package com.example.myapplication.RestApi

import com.google.gson.JsonObject
import com.google.gson.annotations.SerializedName

data class User(
    @SerializedName("firstName")
    val firstName: String,
    @SerializedName("lastName")
    val lastName: String,
    @SerializedName("description")
    val description: String,
    @SerializedName("email")
    val email: String,
    @SerializedName("_links")
    val links: JsonObject
)