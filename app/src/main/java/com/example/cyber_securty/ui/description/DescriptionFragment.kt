package com.example.cyber_securty.ui.description

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.cyber_securty.R
import com.example.cyber_securty.databinding.FragmentDescriptionBinding

class DescriptionFragment : Fragment() {
    private lateinit var binding: FragmentDescriptionBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDescriptionBinding.inflate(layoutInflater)

        return binding.root
    }
}