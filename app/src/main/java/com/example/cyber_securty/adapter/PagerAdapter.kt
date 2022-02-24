package com.example.cyber_securty.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.cyber_securty.ui.description.DescriptionFragment
import com.example.cyber_securty.ui.home.MainFragment

class PagerAdapter(
    private val fragmentActivity: FragmentActivity,
) : FragmentStateAdapter(fragmentActivity) {

    override fun createFragment(position: Int): Fragment {
        when (position) {
            0 -> {
                return MainFragment()
            }
            1 -> {
                return DescriptionFragment()
            }
        }
        return MainFragment()
    }

    override fun getItemCount(): Int {
        return 2
    }
}