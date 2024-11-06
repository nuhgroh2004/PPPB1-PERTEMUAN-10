package com.example.myapplication

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.myapplication.databinding.ItemClubBinding

typealias OnClickDisaster = (Club) -> Unit

class ClubAdapter(
    private val listenDisaster: List<Club>,
    private val onClickDisaster: OnClickDisaster) :
    RecyclerView.Adapter<ClubAdapter.ItemDisasterViewHolder>() {

    inner class ItemDisasterViewHolder(private val binding: ItemClubBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(data: Club){
            with(binding){
                txtName.text = data.nameClub
                Glide.with(imgClub.context)
                    .load(data.img)
                    .into(imgClub)
                itemView.setOnClickListener {
                    onClickDisaster(data)
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemDisasterViewHolder {
        val binding = ItemClubBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ItemDisasterViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return listenDisaster.size
    }

    override fun onBindViewHolder(holder: ItemDisasterViewHolder, position: Int) {
        holder.bind(listenDisaster[position])
    }
}