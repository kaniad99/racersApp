package com.example.myapplication.RestApi

import com.google.gson.annotations.SerializedName

class NewRacer(
    @SerializedName("firstName")
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
    val recordTimeOfTrack: String,
    @SerializedName("href")
    val href: String
) {
    override fun toString(): String {
        return "Racer(firstName='$firstName', lastName='$lastName', dateOfBirth='$dateOfBirth', vehicleBrand='$vehicleBrand', vehicleModel='$vehicleModel', trackName='$trackName', recordTimeOfTrack='$recordTimeOfTrack')"
    }
}