package com.example.myapplication.retrofitRacers

import java.time.LocalDate

data class Racer (
    val id: Long,
    val firstName: String,
    val lastName: String,
    val dateOfBirth: LocalDate,
    val vehicleModel: String,
    val trackName: String,
    val recordTimeOfTrack: String
        )