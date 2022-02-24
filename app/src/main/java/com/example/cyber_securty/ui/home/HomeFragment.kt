package com.example.cyber_securty.ui.home

import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.example.cyber_securty.R
import com.example.cyber_securty.adapter.PagerAdapter
import com.example.cyber_securty.databinding.FragmentHomeBinding
import com.example.cyber_securty.databinding.TabViewBinding
import com.example.cyber_securty.room.entity.StoryData
import com.google.android.material.tabs.TabLayoutMediator

class HomeFragment : Fragment() {
    private lateinit var binding: FragmentHomeBinding
    private lateinit var pagerAdapter: PagerAdapter
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        pagerAdapter = PagerAdapter(requireActivity())
        binding.mainViewPager.adapter = pagerAdapter
        TabLayoutMediator(binding.tablayout, binding.mainViewPager) { tab, position ->
            val bindingTab = TabViewBinding.inflate(layoutInflater)
            tab.customView = bindingTab.root
            when (position) {
                0 -> {
                    bindingTab.batTv.text = "Darsliklar"
                }
                1 -> {
                    bindingTab.batTv.text = "Tafsif"
                }
            }
        }.attach()
        binding.mainDrawerLayout.open()

        binding.drawerMenu.setOnClickListener {
            binding.mainDrawerLayout.openDrawer(Gravity.LEFT)
        }
        return binding.root
    }

    override fun onStart() {
        super.onStart()
        activity?.window?.statusBarColor =
            ContextCompat.getColor(requireContext(), R.color.app_color)
    }
}