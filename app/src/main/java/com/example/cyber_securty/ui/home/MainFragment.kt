package com.example.cyber_securty.ui.home

import android.media.MediaPlayer
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.cyber_securty.R
import com.example.cyber_securty.databinding.ActivityMainBinding
import com.example.cyber_securty.databinding.FragmentMainBinding

class MainFragment : Fragment() {
    private lateinit var binding: FragmentMainBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMainBinding.inflate(layoutInflater)
        binding.title.isSelected = true
        binding.spacer.setOnClickListener {
            val music = MediaPlayer.create(
                requireContext(),
                Uri.parse("https://firebasestorage.googleapis.com/v0/b/cyber-security-57a65.appspot.com/o/speaker.ogg?alt=media&token=a9d83655-1657-4c0b-993d-6377e35afb00")
            )
            music.start()
        }
        binding.continueBtn.setOnClickListener {
            findNavController().navigate(R.id.storyFragment)
        }
        binding.item2.setOnClickListener {
            if (binding.item1Gone.visibility == View.GONE) {
                binding.item1Gone.visibility = View.VISIBLE
            } else {
                binding.item1Gone.visibility = View.GONE
            }
        }
        binding.item3.setOnClickListener {
            if (binding.item2Gone.visibility == View.GONE) {
                binding.item2Gone.visibility = View.VISIBLE
            } else {
                binding.item2Gone.visibility = View.GONE
            }
        }
        binding.item4.setOnClickListener {
            if (binding.item4Gone.visibility == View.GONE) {
                binding.item4Gone.visibility = View.VISIBLE
            } else {
                binding.item4Gone.visibility = View.GONE
            }
        }
        binding.item5.setOnClickListener {
            if (binding.item5Gone.visibility == View.GONE) {
                binding.item5Gone.visibility = View.VISIBLE
            } else {
                binding.item5Gone.visibility = View.GONE
            }
        }
        binding.item6.setOnClickListener {
            if (binding.item6Gone.visibility == View.GONE) {
                binding.item6Gone.visibility = View.VISIBLE
            } else {
                binding.item6Gone.visibility = View.GONE
            }
        }
        binding.item7.setOnClickListener {
            if (binding.item7Gone.visibility == View.GONE) {
                binding.item7Gone.visibility = View.VISIBLE
            } else {
                binding.item7Gone.visibility = View.GONE
            }
        }
        return binding.root
    }

    override fun onResume() {
        super.onResume()
    }
}