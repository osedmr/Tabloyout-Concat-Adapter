package com.example.getir.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.getir.data.ProductModel
import com.example.getir.databinding.ProductCardViewBinding

class GazliItemAdapter : RecyclerView.Adapter<GazliItemAdapter.GazliItemViewHolder>() {
    private val gazliProductList = ArrayList<ProductModel>()

    inner class GazliItemViewHolder(val binding: ProductCardViewBinding) : RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GazliItemViewHolder {
        val binding = ProductCardViewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return GazliItemViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return gazliProductList.size
    }

    override fun onBindViewHolder(holder: GazliItemViewHolder, position: Int) {
        val product = gazliProductList[position]
        holder.binding.productImageView.setImageResource(product.yemek_resim_adi)
        holder.binding.productPriceText.text = "€ ${product.yemek_fiyat}"
        holder.binding.productNameText.text = product.product_name
        holder.binding.bilgiText.text = product.bilgi
    }

    fun updateList(list: List<ProductModel>) {
        gazliProductList.clear()
        gazliProductList.addAll(list)
        notifyItemRangeChanged(0, gazliProductList.size - 1)

    }
}