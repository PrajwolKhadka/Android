package com.example.task

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.task.databinding.ActivityButtonBinding

class ButtonActivity : AppCompatActivity() {
    lateinit var binding: ActivityButtonBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding= ActivityButtonBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnNavigate.setOnClickListener{
            val intent= Intent(this@ButtonActivity, DesignedActivity::class.java)
            startActivity(intent)
            finish()
        }
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}