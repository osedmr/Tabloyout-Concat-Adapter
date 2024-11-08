package com.example.getir.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.getir.fragments.BlankFragment
import com.example.getir.fragments.FirstFragment
import com.example.getir.fragments.FourFragment
import com.example.getir.fragments.SecondFragment
import com.example.getir.fragments.ThirdFragment

class ViewPagerAdapter(fragment:FragmentActivity) : FragmentStateAdapter(fragment) {
    val fragments = listOf(FirstFragment(), SecondFragment(), ThirdFragment(), FourFragment(),
        BlankFragment()
    )
    override fun getItemCount(): Int {
        return fragments.size
    }

    override fun createFragment(position: Int): Fragment {
        return fragments[position]
    }
}