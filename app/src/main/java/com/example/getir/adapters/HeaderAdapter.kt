package com.example.getir.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.getir.databinding.HeaderCardViewBinding

class HeaderAdapter(val headerText: String) : RecyclerView.Adapter<HeaderAdapter.HeaderViewHolder>() {
    inner class HeaderViewHolder(val binding: HeaderCardViewBinding) :RecyclerView.ViewHolder(binding.root)  {

    }
    override fun getItemCount(): Int {
        return 1
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HeaderViewHolder {
        val binding = HeaderCardViewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return HeaderViewHolder(binding)
    }



    override fun onBindViewHolder(holder: HeaderViewHolder, position: Int) {
        holder.binding.tvHeader.text = headerText
    }
}