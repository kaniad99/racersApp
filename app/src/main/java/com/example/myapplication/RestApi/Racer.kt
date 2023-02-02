package com.example.myapplication.RestApi

import com.google.gson.annotations.SerializedName

class Racer(
    @SerializedName("firstname")
    val firstName: String,
    @SerializedName("lastName")
    val lastName: String,
    @SerializedName("dateOfBirth")
    val dateOfBirth: String,
    @SerializedName("vehicleBrand")
    val vehicleBrand: String,
    @SerializedName("vehicleModel")
    val vehicleModel: String,
    @SerializedName("trackName")
    val trackName: String,
    @SerializedName("recordTimeOfTrack")
    val recordTimeOfTrack: String
)