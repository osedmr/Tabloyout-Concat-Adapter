package com.example.getir.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.getir.data.ProductModel
import com.example.getir.databinding.ProductCardViewBinding

class WaterItemAdapter : RecyclerView.Adapter<WaterItemAdapter.WaterItemViewHolder>() {
    private val waterProductList = ArrayList<ProductModel>()
    inner class WaterItemViewHolder(val binding: ProductCardViewBinding) : RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WaterItemViewHolder {
        val binding = ProductCardViewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return WaterItemViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return waterProductList.size
    }

    override fun onBindViewHolder(holder: WaterItemViewHolder, position: Int) {
        val product = waterProductList[position]
        holder.binding.productImageView.setImageResource(product.yemek_resim_adi)
        holder.binding.productPriceText.text = "€ ${product.yemek_fiyat}"
        holder.binding.productNameText.text = product.product_name
        holder.binding.bilgiText.text = product.bilgi
    }

    fun updateList(newList: List<ProductModel>) {
        waterProductList.clear()
        waterProductList.addAll(newList)
        notifyItemRangeChanged(0, waterProductList.size - 1)

    }
}