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
import com.example.getir.adapters.WaterListAdapter
import com.example.getir.data.ProductData
import com.example.getir.databinding.ActivityMainBinding
import com.google.android.material.tabs.TabLayout

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    private val waterListAdapter = WaterListAdapter()
    private val waterHeaderAdapter = HeaderAdapter("Su")

    private val ayranListAdapter = AyranListAdapter()
    private val ayranHeaderAdapter = HeaderAdapter("Ayran")

    private val gazliListAdapter = GazliListAdapter()
    private val gazliHeaderAdapter = HeaderAdapter("Gazlı içecek")



    private val sectionPositions = listOf(
        0,  // "Su" başlığı
        waterHeaderAdapter.itemCount + waterListAdapter.itemCount, // "Ayran" başlığı
        waterHeaderAdapter.itemCount + waterListAdapter.itemCount +
                ayranHeaderAdapter.itemCount + ayranListAdapter.itemCount // "Gazlı İçecek" başlığı
    )

    private var concatAdapter = ConcatAdapter()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)




        waterListAdapter.updateList(ProductData.getWater())
        ayranListAdapter.updateList(ProductData.getAyran())
        gazliListAdapter.updateList(ProductData.getGazli())


        concatAdapter = ConcatAdapter(
            waterHeaderAdapter,
            waterListAdapter,
            ayranHeaderAdapter,
            ayranListAdapter,
            gazliHeaderAdapter,
            gazliListAdapter
        )

        binding.rvConcat.adapter=concatAdapter
        binding.rvConcat.layoutManager= LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)

        setupTabLayout()

        binding.rvConcat.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)
                updateTabOnScroll()
            }
        })

    }

    private fun setupTabLayout() {
        binding.tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab) {
                val layoutManager = binding.rvConcat.layoutManager as LinearLayoutManager
                when (tab.position) {
                    0 -> layoutManager.scrollToPositionWithOffset(sectionPositions[0], 0)
                    1 -> layoutManager.scrollToPositionWithOffset(sectionPositions[1], 0)
                    2 -> layoutManager.scrollToPositionWithOffset(sectionPositions[2], 0)
                }
            }

            override fun onTabUnselected(tab: TabLayout.Tab) {}
            override fun onTabReselected(tab: TabLayout.Tab) {}
        })
    }


    private fun updateTabOnScroll() {
        val layoutManager = binding.rvConcat.layoutManager as LinearLayoutManager
        val firstVisiblePosition = layoutManager.findFirstVisibleItemPosition()

        val tabIndex = when {
            firstVisiblePosition >= sectionPositions[2] -> 2 // Gazlı İçecek
            firstVisiblePosition >= sectionPositions[1] -> 1 // Ayran
            else -> 0 // Su
        }

        // Aktif sekme değişmişse güncelle
        if (binding.tabLayout.selectedTabPosition != tabIndex) {
            binding.tabLayout.getTabAt(tabIndex)?.select()
        }
    }
}

