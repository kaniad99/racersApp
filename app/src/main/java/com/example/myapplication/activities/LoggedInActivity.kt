package com.example.myapplication.activities

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.activities.racerslist.RacersListActivity
import com.example.myapplication.activities.userslist.UsersListActivity
import com.example.myapplication.databinding.ActivityLoggedInBinding

class LoggedInActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoggedInBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityLoggedInBinding.inflate(layoutInflater)

        binding.racersButton.setOnClickListener {
            val intent = Intent(this@LoggedInActivity, RacersListActivity::class.java)
            startActivity(intent)
        }

        binding.usersButton.setOnClickListener {
            val intent = Intent(this@LoggedInActivity, UsersListActivity::class.java)
            startActivity(intent)
        }
        setContentView(binding.root)
    }
}