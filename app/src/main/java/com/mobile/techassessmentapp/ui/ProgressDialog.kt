package com.mobile.techassessmentapp.ui

import android.app.Dialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.view.LayoutInflater
import com.mobile.techassessmentapp.R

class ProgressDialog{
    companion object {
        fun makeDialog(context: Context?): Dialog? {
            context?.let {
                val dialog = Dialog(context)
                val inflate = LayoutInflater.from(context).inflate(R.layout.progress_dailog, null)

//                GlideApp.with(context).asGif().load(R.drawable.loader).into(inflate.progressLoader)
                dialog.setContentView(inflate)
                dialog.setCancelable(false)
                dialog.window!!.setBackgroundDrawable(
                    ColorDrawable(Color.TRANSPARENT)
                )
                return dialog
            }
            return null
        }
    }
}