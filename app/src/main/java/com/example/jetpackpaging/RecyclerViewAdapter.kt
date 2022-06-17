package com.example.jetpackpaging

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.jetpackpaging.network.CharacterData

class RecyclerViewAdapter: PagingDataAdapter<CharacterData, RecyclerViewAdapter.MyViewHolder>(DiffUtilCallback()) {

    override fun onBindViewHolder(holder: RecyclerViewAdapter.MyViewHolder, position: Int) {
        holder.bind(getItem(position)!!)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerViewAdapter.MyViewHolder {
        val inflater = LayoutInflater.from(parent.context).inflate(R.layout.recycler_row,parent,false)
        return MyViewHolder(inflater)
    }

    class MyViewHolder(view: View):RecyclerView.ViewHolder(view){
        val imageView: ImageView = view.findViewById(R.id.imageView)
        val tvName: TextView = view.findViewById(R.id.tvName)
        val tvDesc: TextView = view.findViewById(R.id.tvDesc)
        val status: TextView = view.findViewById(R.id.status)
        val gender: TextView = view.findViewById(R.id.gender)
        fun bind(data: CharacterData){
            tvName.text = data.name
            tvDesc.text = data.species
            status.text = data.status
            gender.text = data.gender
            Glide.with(imageView)
                .load(data.image)
                .circleCrop()
                .into(imageView)
        }
    }

    class DiffUtilCallback:DiffUtil.ItemCallback<CharacterData>(){
        override fun areItemsTheSame(oldItem: CharacterData, newItem: CharacterData): Boolean {
            return oldItem.name==newItem.name
        }

        override fun areContentsTheSame(oldItem: CharacterData, newItem: CharacterData): Boolean {
            return oldItem.name == newItem.name
                    && oldItem.species == newItem.species
        }

    }

}