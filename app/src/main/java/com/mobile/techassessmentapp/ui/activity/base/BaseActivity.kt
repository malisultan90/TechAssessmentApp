package com.mobile.techassessmentapp.ui.activity.base

import android.app.Dialog
import android.content.Intent
import android.os.Bundle
import androidx.annotation.Nullable
import androidx.appcompat.app.AppCompatActivity
import com.mobile.techassessmentapp.ui.ProgressDialog

abstract class BaseActivity : AppCompatActivity()  {

    protected abstract fun getContentView(): Int

   // protected var progressDialog: Dialog? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (getContentView() != 0) {
            setContentView(getContentView())
        }
      //  progressDialog = ProgressDialog.makeDialog(this)
    }

//     fun showProgressDialog() {
//         if (isFinishing && progressDialog!=null && progressDialog?.isShowing == false) {
//             progressDialog?.show()
//         }
//     }
//
//     fun hideProgressDialog() {
//         if (isFinishing && progressDialog!=null && progressDialog?.isShowing == true) {
//             progressDialog?.dismiss()
//         }
//     }

    protected fun openActivity(calledActivity: Class<*>, @Nullable bundle: Bundle?) {
        val myIntent = Intent(this, calledActivity)
        if (bundle != null) {
            myIntent.putExtras(bundle)
        }
        this.startActivity(myIntent)
    }

    protected fun openActivity(calledActivity: Class<*>) {
        openActivity(calledActivity, null)
    }
}