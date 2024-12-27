package com.example.task.UI.activity

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.example.task.R
import com.example.task.UI.fragment.HomeFragment
import com.example.task.UI.fragment.NotificationFragment
import com.example.task.UI.fragment.ProfileFragment
import com.example.task.UI.fragment.VideoFragment
import com.example.task.databinding.ActivityHomeBinding
import com.example.task.databinding.ActivityNavigationBinding

class NavigationActivity : AppCompatActivity() {
    lateinit var binding: ActivityNavigationBinding
    private fun replaceFragment(fragment: Fragment){
        val fragmentManager: FragmentManager = supportFragmentManager
        val fragmentTransaction : FragmentTransaction = fragmentManager.beginTransaction()

        fragmentTransaction.replace(R.id.frameLayout,fragment)
        fragmentTransaction.commit()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding= ActivityNavigationBinding.inflate(layoutInflater)
        setContentView(binding.root)
        replaceFragment(HomeFragment())
        binding.bottomNavigationView.setOnItemSelectedListener {
            when(it.itemId){
                R.id.Home->replaceFragment(HomeFragment())
                R.id.Video->replaceFragment(VideoFragment())
                R.id.Person->replaceFragment(ProfileFragment())
                R.id.navNotification->replaceFragment(NotificationFragment())
            }
            true
        }
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}