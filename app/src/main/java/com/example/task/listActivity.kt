package com.example.task

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.widget.Toast

class listActivity : AppCompatActivity(){
    lateinit var listView : ListView

    val contacts= arrayOf("Hello","Bonjour","Namaste",
        "Hello","Bonjour","Namaste",
        "Hello","Bonjour","Namaste",
        "Hello","Bonjour","Namaste",
        "Hello","Bonjour","Namaste",
        "Hello","Bonjour","Namaste",
        "Hello","Bonjour","Namaste",
        "Hello","Bonjour","Namaste")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_list)
        listView=findViewById(R.id.list)
        val adapter= ArrayAdapter(
            this@listActivity, android.R.layout.simple_list_item_1, contacts
        )
        listView.adapter=adapter
        listView.setOnItemClickListener{adapterView, view, position, l->
            Toast.makeText(this@listActivity, adapterView.getItemAtPosition(position).toString(), Toast.LENGTH_SHORT).show()
        }
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}