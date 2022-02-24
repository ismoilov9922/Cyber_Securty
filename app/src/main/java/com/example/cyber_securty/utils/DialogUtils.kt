package com.example.cyber_securty.utils

import android.app.AlertDialog
import android.content.Context
import android.view.LayoutInflater
import androidx.navigation.fragment.NavHostFragment.Companion.findNavController
import com.example.cyber_securty.R
import com.example.cyber_securty.databinding.DialogMemberInfoBinding

object DialogUtils {
    fun getAlertDialog(context: Context) {
        val dialogBinding =
            DialogMemberInfoBinding.inflate(LayoutInflater.from(context))
        val dialogBuilder = AlertDialog.Builder(context)
        val alertDialog = dialogBuilder.create()
        alertDialog.setView(dialogBinding.root)
        alertDialog.window?.setBackgroundDrawableResource(android.R.color.transparent)
        dialogBinding.cancelBtn.setOnClickListener {
            alertDialog.dismiss()
        }
        dialogBinding.quit.setOnClickListener {
            alertDialog.dismiss()
        }
        alertDialog.show()
    }
}