package com.example.myapplication.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.myapplication.R
import com.example.myapplication.RestApi.NewRacer
import com.example.myapplication.RestApi.Racer
import com.example.myapplication.RestApi.Service
import com.example.myapplication.activities.racerslist.RacersListActivity
import com.example.myapplication.databinding.ActivityCreateRacerBinding
import com.example.myapplication.databinding.ActivityRacersListBinding
import com.google.gson.JsonObject
import java.time.LocalDate

class CreateRacerActivity : AppCompatActivity() {
    private lateinit var binding: ActivityCreateRacerBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCreateRacerBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.createButton.setOnClickListener {
            val service = Service()

            val racer = Racer(
                binding.textFirstName.text.toString(),
                binding.textLastName.text.toString(),
                binding.textDateOfBirth.text.toString(),
                binding.textVehicleBrand.text.toString(),
                binding.textVehicleModel.text.toString(),
                binding.textTrackName.text.toString(),
                binding.textRecordTime.text.toString(),
                JsonObject())

            if(service.addRacer(racer)){
                Toast.makeText(applicationContext, "Created new racer", Toast.LENGTH_SHORT).show()
                finish()
            }
        }
    }
}