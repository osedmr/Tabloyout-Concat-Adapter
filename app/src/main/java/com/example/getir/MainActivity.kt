package com.example.getir

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.ConcatAdapter
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.getir.adapters.AyranListAdapter
import com.example.getir.adapters.GazliListAdapter
import com.example.getir.adapters.HeaderAdapter
import com.example.getir.adapters.ViewPagerAdapter
import com.example.getir.adapters.WaterListAdapter
import com.example.getir.data.ProductData
import com.example.getir.databinding.ActivityMainBinding
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var viewPagerAdapter : ViewPagerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        viewPagerAdapter = ViewPagerAdapter(this)
        binding.viewPager2.adapter = viewPagerAdapter

        TabLayoutMediator(binding.tabLayout, binding.viewPager2) { tab, position ->
            when (position) {
                0 -> {
                    tab.text = "Atıştırmalık"

                }
                1 -> {
                    tab.text = "Su & İçecek"

                }
                2 -> {
                    tab.text = "Meyve & Sebze"

                }
                3 -> {
                    tab.text = "Süt Ürünleri"

                }
                4 -> {
                    tab.text = "Gol Olur"

                }

            }
        }.attach()













    }








}

