package com.example.task

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.task.databinding.ActivityButtonBinding

class ButtonActivity : AppCompatActivity() {
    lateinit var binding: ActivityButtonBinding
    lateinit var sharedPreferences: SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding= ActivityButtonBinding.inflate(layoutInflater)
        setContentView(binding.root)
        sharedPreferences= getSharedPreferences("userData", Context.MODE_PRIVATE)
        binding.btnNavigate.setOnClickListener{

            val username: String = binding.editUser.text.toString()
            val pass: String= binding.editPass.text.toString()
            if(username.isEmpty()){
                binding.editUser.error="Username can't be empty"
            }
            else if(pass.isEmpty()){
                binding.editPass.error="Password can't be empty"
            }
            else{
                if(binding.remember.isChecked){
                    val editor= sharedPreferences.edit()

                    editor.putString("username", username)
                    editor.putString("password",pass)
                    editor.apply()
                }
                val intent= Intent(this@ButtonActivity, DestinationActivity::class.java)
                intent.putExtra("username",username)
                intent.putExtra("password",pass)
                startActivity(intent)
            }

        }
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}