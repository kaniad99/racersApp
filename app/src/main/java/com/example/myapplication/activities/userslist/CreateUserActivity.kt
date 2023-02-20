package com.example.myapplication.activities.userslist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.myapplication.R
import com.example.myapplication.RestApi.Racer
import com.example.myapplication.RestApi.Service
import com.example.myapplication.RestApi.User
import com.example.myapplication.databinding.ActivityCreateRacerBinding
import com.example.myapplication.databinding.ActivityCreateUserBinding
import com.google.gson.JsonObject

class CreateUserActivity : AppCompatActivity() {
    private lateinit var binding: ActivityCreateUserBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityCreateUserBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.createButton.setOnClickListener {
            val service = Service()

            val user = User(
                binding.textFirstName.text.toString(),
                binding.textLastName.text.toString(),
                binding.textDescription.text.toString(),
                binding.textEmail.text.toString(),
                JsonObject()
            )

            if(service.addUser(user)){
                Toast.makeText(applicationContext, "Created new user", Toast.LENGTH_SHORT).show()
                finish()
            }
        }
    }
}