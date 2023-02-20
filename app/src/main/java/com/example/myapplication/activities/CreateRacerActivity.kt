package com.example.myapplication.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.myapplication.R
import com.example.myapplication.RestApi.Racer
import com.example.myapplication.RestApi.Service
import com.example.myapplication.databinding.ActivityCreateRacerBinding
import com.example.myapplication.databinding.ActivityRacersListBinding
import java.time.LocalDate

class CreateRacerActivity : AppCompatActivity() {
    private lateinit var binding: ActivityCreateRacerBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCreateRacerBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.createButton.setOnClickListener {
            val service = Service()


            val racer = Racer("Adam", "Mickiewicz", "sdf", "dsf", "df", "df", "df")

            service.addRacer(racer)
        }
    }
}