package com.example.getir.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.getir.data.ProductModel
import com.example.getir.databinding.WaterListRvBinding

class AyranListAdapter : RecyclerView.Adapter<AyranListAdapter.AyranListViewHolder>() {

    private val ayranProductList = ArrayList<ProductModel>()

    inner class AyranListViewHolder(val binding: WaterListRvBinding) : RecyclerView.ViewHolder(binding.root) {

    }
    override fun getItemCount(): Int = 1

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AyranListViewHolder {
        val binding = WaterListRvBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return AyranListViewHolder(binding)
    }



    override fun onBindViewHolder(holder: AyranListViewHolder, position: Int) {
        holder.binding.waterListRv.apply {
            layoutManager = GridLayoutManager(context, 3, LinearLayoutManager.VERTICAL, false)
            adapter = AyranItemAdapter().also {
                it.updateList(ayranProductList)
            }
        }
    }
    fun updateList(newList: List<ProductModel>) {
        ayranProductList.clear()
        ayranProductList.addAll(newList)
        notifyItemRangeChanged(0, ayranProductList.size - 1)

    }
}