package com.example.getir.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.ConcatAdapter
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.getir.R
import com.example.getir.adapters.AyranListAdapter
import com.example.getir.adapters.GazliListAdapter
import com.example.getir.adapters.HeaderAdapter
import com.example.getir.adapters.WaterListAdapter
import com.example.getir.data.ProductData
import com.example.getir.databinding.FragmentSecondBinding
import com.iammert.tabscrollattacherlib.TabScrollAttacher


class SecondFragment : Fragment() {

    private lateinit var binding: FragmentSecondBinding
    private val waterListAdapter = WaterListAdapter()
    private val waterHeaderAdapter = HeaderAdapter("Su")

    private val ayranListAdapter = AyranListAdapter()
    private val ayranHeaderAdapter = HeaderAdapter("Ayran")

    private val gazliListAdapter = GazliListAdapter()
    private val gazliHeaderAdapter = HeaderAdapter("Gazlı içecek")

    private var concatAdapter = ConcatAdapter()

    private val sectionTitles = listOf("Su", "Ayran", "Gazlı içecek")
    private val sectionPositions = listOf(0,3,5)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentSecondBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

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
        binding.rvConcat.layoutManager= LinearLayoutManager(context, LinearLayoutManager.VERTICAL,false)

        sectionTitles.forEach {title ->
            binding.tabLayout.addTab(binding.tabLayout.newTab().setText(title))
        }
        val attacher = TabScrollAttacher(binding.tabLayout, binding.rvConcat, sectionPositions) {
            scrollSmoothly()
        }

        attacher.attach()

    }


}