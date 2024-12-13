package com.example.task

import android.content.DialogInterface
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.snackbar.Snackbar

class Bar : AppCompatActivity() {
    lateinit var buttonAlert: Button
    lateinit var buttonToast: Button
    lateinit var buttonStack: Button
    lateinit var main: ConstraintLayout
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_bar)
        main= findViewById(R.id.main)
        buttonAlert = findViewById(R.id.alert)
        buttonToast = findViewById(R.id.toast)
        buttonStack = findViewById(R.id.stack)

        buttonToast.setOnClickListener{
            Toast.makeText(
                this@Bar, "Invalid Login", Toast.LENGTH_LONG).show()
        }
        buttonStack.setOnClickListener{
            Snackbar.make(main, "Unable to login", Snackbar.LENGTH_LONG).setAction("ok",{}).show()
        }
        buttonAlert.setOnClickListener{
            val alert = AlertDialog.Builder(this@Bar)
            alert.setTitle("Warning")
                .setMessage("are you sure")
                .setIcon(R.drawable.apple)
                .setPositiveButton("Yes",
                    DialogInterface.OnClickListener
                    { dialogInterface, i ->
                        //logic
                    })
                .setNegativeButton("No",
                    DialogInterface.OnClickListener
                    { dialogInterface, i ->
                        dialogInterface.dismiss()
                    })
            alert.create().show()
        }
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}