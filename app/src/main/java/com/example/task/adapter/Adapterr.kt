package com.example.task.adapter

import android.content.Context
import android.media.Image
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.task.R

class Adapterr
    ( val context: Context,
      val imageList:ArrayList<Int>,
      val titleList:ArrayList<String>,
      val descList: ArrayList<String>): RecyclerView.Adapter<Adapterr.adapterViewHolder>()
{
    class adapterViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        var image: ImageView=itemView.findViewById(R.id.apple)
        var title: TextView= itemView.findViewById(R.id.title1)
        var desc: TextView= itemView.findViewById(R.id.dis)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): adapterViewHolder {
        val itemView: View=LayoutInflater.from(context).inflate(R.layout.sample_fruit, parent, false)
        return adapterViewHolder(itemView )
    }

    override fun getItemCount(): Int {
        return imageList.size;
    }

    override fun onBindViewHolder(holder: adapterViewHolder, position: Int) {
        holder.image.setImageResource(imageList[position])
        holder.title.text = titleList[position]
        holder.desc.text = descList[position]
    }
}



