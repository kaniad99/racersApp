package com.example.myapplication

import android.os.Bundle
import android.os.StrictMode
import android.os.StrictMode.ThreadPolicy
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import com.example.myapplication.databinding.ActivityMainBinding
import com.example.myapplication.databinding.LoginLayoutBinding
import okhttp3.*
import okio.IOException


class MainActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
//    private lateinit var binding: ActivityMainBinding
    private lateinit var binding: LoginLayoutBinding
    private lateinit var responseBody: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = LoginLayoutBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        setSupportActionBar(binding.toolbar)

//        val navController = findNavController(R.id.nav_host_fragment_content_main)
//        appBarConfiguration = AppBarConfiguration(navController.graph)
//        setupActionBarWithNavController(navController, appBarConfiguration)

        val policy = ThreadPolicy.Builder().permitAll().build()
        StrictMode.setThreadPolicy(policy)


        binding.authenticate.setOnClickListener {
            Thread {
                authenticate()
                runOnUiThread {
                    Toast.makeText(this, "DUPA", Toast.LENGTH_SHORT).show()
                }
            }.start()
        }
    }


    private fun authenticate() {
        val client = OkHttpClient.Builder()
            .authenticator(object : Authenticator {
                @Throws(IOException::class)
                override fun authenticate(route: Route?, response: Response): Request? {
                    if (response.request.header("Authorization") != null) {
                        return null // Give up, we've already attempted to authenticate.
                    }

                    println("Authenticating for response: $response")
                    println("Challenges: ${response.challenges()}")
                    val credential = Credentials.basic("admin", "admin")
                    return response.request.newBuilder()
                        .header("Authorization", credential)
                        .build()
                }
            })
            .build()

//
//        val request = Request.Builder()
//            .url("https://publicobject.com/helloworld.txt")
//            .build()
//
        val request = Request.Builder()
            .url("http://10.0.2.2:8080/api/racers?size=20")
            .build()

        client.newCall(request).execute().use { response ->
            if (!response.isSuccessful) {
                Log.e("Request: Unexpected code: ", response.code.toString())
            }

            for ((name, value) in response.headers) {
                Log.d("Response: ", "$name: $value")
            }

            Log.d("Response Code: ", response.code.toString())

            responseBody = response.body!!.string()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment_content_main)
        return navController.navigateUp(appBarConfiguration)
                || super.onSupportNavigateUp()
    }


}