package com.example.getir.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.getir.data.ProductModel
import com.example.getir.databinding.ProductCardViewBinding
import com.example.getir.databinding.WaterListRvBinding

class GazliListAdapter : RecyclerView.Adapter<GazliListAdapter.GazliListViewHolder>()  {

    private val gazliProductList = ArrayList<ProductModel>()

    inner class GazliListViewHolder(val binding: WaterListRvBinding) : RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GazliListViewHolder {
        val binding =WaterListRvBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return GazliListViewHolder(binding)
    }

    override fun getItemCount(): Int = 1

    override fun onBindViewHolder(holder: GazliListViewHolder, position: Int) {
        holder.binding.waterListRv.apply {
            layoutManager = GridLayoutManager(context, 3, LinearLayoutManager.VERTICAL, false)
            adapter = GazliItemAdapter().also {
                it.updateList(gazliProductList)
            }
        }
    }

    fun updateList(list: List<ProductModel>) {
        gazliProductList.clear()
        gazliProductList.addAll(list)
        notifyItemRangeChanged(0, gazliProductList.size - 1)
    }
}