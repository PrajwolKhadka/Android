package com.example.task

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter
import com.example.task.adapter.Adapterr

class DesignedActivity : AppCompatActivity() {
    lateinit var recycleView: RecyclerView
    var imageList=ArrayList<Int>()
    var titleList=ArrayList<String>()
    var descList=ArrayList<String>()

    lateinit var adapter: Adapterr
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_designed)
        recycleView = findViewById(R.id.recycle)
        imageList.add(R.drawable.apple)
        imageList.add(R.drawable.k)
        imageList.add(R.drawable.b)

        titleList.add("apple")
        titleList.add("logo")
        titleList.add("bee")

        descList.add("A for apple")
        descList.add("K FOR King")
        descList.add("B for bee")

        adapter = Adapterr(
            this@DesignedActivity, imageList, titleList, descList
        )
        recycleView.adapter=adapter
        recycleView.layoutManager= LinearLayoutManager(this@DesignedActivity, LinearLayoutManager.HORIZONTAL,false)
//        recycleView.layoutManager= GridLayoutManager(this@DesignedActivity, 2)


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}