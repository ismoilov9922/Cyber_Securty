package com.example.cyber_securty.ui.audio

import android.app.AlertDialog
import android.content.Intent
import android.media.MediaPlayer
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.activity.OnBackPressedCallback
import androidx.core.content.ContextCompat
import androidx.core.view.marginTop
import androidx.navigation.fragment.findNavController
import com.example.cyber_securty.R
import com.example.cyber_securty.databinding.DialogMemberInfoBinding
import com.example.cyber_securty.databinding.FragmentLessonFourBinding
import com.example.cyber_securty.databinding.FragmentLessonThreeBinding
import com.example.cyber_securty.room.entity.StoryData
import com.example.cyber_securty.utils.LoadList

class LessonFourFragment : Fragment() {
    private lateinit var binding: FragmentLessonFourBinding
    private lateinit var list: ArrayList<StoryData>
    private var music: MediaPlayer = MediaPlayer()
    private var count = 0
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentLessonFourBinding.inflate(layoutInflater)
        list = LoadList.loadList13() as ArrayList<StoryData>
        return binding.root
    }

    override fun onResume() {
        super.onResume()
        addView(list[count])
        onBackPressed()
        binding.share.setOnClickListener {
            val intent = Intent(Intent.ACTION_SEND)
            intent.type = "text/plain"
            intent.putExtra(Intent.EXTRA_SUBJECT, "Cyber Security")
            intent.putExtra(
                Intent.EXTRA_TEXT,
                "https://bit.ly/2Q7LeIH"
            )
            startActivity(Intent.createChooser(intent, "choose one"))
        }
        binding.continueTv.setOnClickListener {
            addView(list[count])
        }
        binding.next.setOnClickListener {
            findNavController().popBackStack()
            findNavController().navigate(R.id.lessonTwoFragment)
        }
        binding.close.setOnClickListener {
            backDialog()
        }
    }

    private fun addView(storyData: StoryData) {
        music.stop()
        val cricketerView: View = layoutInflater.inflate(R.layout.item_text_view, null, false)
        val textView = cricketerView.findViewById<View>(R.id.text_item_1) as TextView
        textView.marginTop.compareTo(10)
        onBackPressed()
        music = MediaPlayer.create(requireContext(), Uri.parse(storyData.audioUrl))
        music.start()
        textView.text = storyData.audioText
        binding.textView.addView(cricketerView)
        if (count == list.size - 1) {
            binding.continueTv.visibility = View.GONE
            binding.next.visibility = View.VISIBLE
        } else {
            count++
        }
    }

    override fun onStart() {
        super.onStart()
        activity?.window?.statusBarColor = ContextCompat.getColor(requireContext(), R.color.blue)
    }

    override fun onDestroy() {
        super.onDestroy()
        music.stop()
    }

    private fun backDialog() {
        val dialogBinding =
            DialogMemberInfoBinding.inflate(layoutInflater)
        val dialogBuilder = AlertDialog.Builder(requireContext())
        val alertDialog = dialogBuilder.create()
        alertDialog.setView(dialogBinding.root)
        alertDialog.window?.setBackgroundDrawableResource(android.R.color.transparent)
        dialogBinding.cancelBtn.setOnClickListener {
            alertDialog.dismiss()
        }
        dialogBinding.quit.setOnClickListener {
            alertDialog.dismiss()
            findNavController().popBackStack()
        }
        alertDialog.show()
    }

    private fun onBackPressed() {
        val callBack = object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                backDialog()
            }
        }
        requireActivity().onBackPressedDispatcher.addCallback(callBack)
    }
}