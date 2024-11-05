package com.example.getir.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.getir.data.ProductModel
import com.example.getir.databinding.ProductCardViewBinding

class AyranItemAdapter : RecyclerView.Adapter<AyranItemAdapter.AyranItemViewHolder>() {
    private val ayranProductList = ArrayList<ProductModel>()

    inner class AyranItemViewHolder(val binding: ProductCardViewBinding) : RecyclerView.ViewHolder(binding.root) {

    }
    override fun getItemCount(): Int {
        return ayranProductList.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AyranItemViewHolder {
        val binding = ProductCardViewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return AyranItemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: AyranItemViewHolder, position: Int) {
        val product = ayranProductList[position]
        holder.binding.productImageView.setImageResource(product.yemek_resim_adi)
        holder.binding.productPriceText.text = "€ ${product.yemek_fiyat}"
        holder.binding.productNameText.text = product.product_name
        holder.binding.bilgiText.text = product.bilgi
    }

    fun updateList(newList: List<ProductModel>) {
        ayranProductList.clear()
        ayranProductList.addAll(newList)
        notifyItemRangeChanged(0, ayranProductList.size - 1)

    }
}