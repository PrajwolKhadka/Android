package com.example.task

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class SplashAcitivity : AppCompatActivity() {
    lateinit var sharedPreferences: SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_splash_acitivity)

        sharedPreferences= getSharedPreferences("userData", Context.MODE_PRIVATE)

        Handler(Looper.getMainLooper()).postDelayed({
            val username: String = sharedPreferences.getString("username","").toString()

            if(username.isEmpty()){
                val intent= Intent(this@SplashAcitivity,ButtonActivity::class.java)
                startActivity(intent)
                finish()
            }else{
            val intent= Intent(this@SplashAcitivity,DestinationActivity::class.java)
            startActivity(intent)
            finish()}
        }, 3000)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}