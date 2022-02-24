package com.example.cyber_securty.ui.splash

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import androidx.core.content.ContextCompat
import androidx.navigation.fragment.findNavController
import com.example.cyber_securty.R
import com.example.cyber_securty.databinding.FragmentSplashBinding

class SplashFragment : Fragment() {
    lateinit var binding: FragmentSplashBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSplashBinding.inflate(layoutInflater)
        val animation = AnimationUtils.loadAnimation(requireContext(), R.anim.anim)
        binding.text2.animation = animation
        Handler(Looper.getMainLooper()).postDelayed({
            findNavController().popBackStack()
            findNavController().navigate(R.id.home_fragment)
        }, 2500)
        return binding.root
    }

    override fun onStart() {
        super.onStart()
        activity?.window?.statusBarColor = ContextCompat.getColor(requireContext(), R.color.blue)
    }

    override fun onDestroy() {
        super.onDestroy()
        activity?.window?.statusBarColor =
            ContextCompat.getColor(requireContext(), R.color.app_color)
    }
}