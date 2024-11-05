package com.example.getir.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.getir.data.ProductModel
import com.example.getir.databinding.WaterListRvBinding

class WaterListAdapter() : RecyclerView.Adapter<WaterListAdapter.WaterListViewHolder>() {
    private val waterProductList = ArrayList<ProductModel>()
    inner class WaterListViewHolder(val binding: WaterListRvBinding) : RecyclerView.ViewHolder(binding.root) {

    }
    override fun getItemCount(): Int = 1

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WaterListViewHolder {
        val binding = WaterListRvBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return WaterListViewHolder(binding)
    }



    override fun onBindViewHolder(holder: WaterListViewHolder, position: Int) {
        holder.binding.waterListRv.apply {
            layoutManager = GridLayoutManager(context, 3, LinearLayoutManager.VERTICAL, false)
            adapter = WaterItemAdapter().also {
                it.updateList(waterProductList)
            }
        }
    }
    fun updateList(newList: List<ProductModel>) {
        waterProductList.clear()
        waterProductList.addAll(newList)
        notifyItemRangeChanged(0, waterProductList.size - 1)

    }
}