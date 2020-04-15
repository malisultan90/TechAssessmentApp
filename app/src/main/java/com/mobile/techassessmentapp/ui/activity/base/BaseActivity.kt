package com.mobile.techassessmentapp.ui.activity.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import com.mobile.techassessmentapp.R
import com.mobile.techassessmentapp.databinding.ActivityDetailBinding
import com.mobile.techassessmentapp.ui.activity.detail.DetailActivityViewModel
import com.mobile.techassessmentapp.utils.AppViewModelFactory
import dagger.android.AndroidInjection
import javax.inject.Inject

abstract class BaseActivity : AppCompatActivity() {

    @Inject
    lateinit var viewModelFactory: AppViewModelFactory

    //    private val viewModel by lazy {
//        ViewModelProviders.of(this, viewModelFactory).get(
//            T::class.java
//        )
//    }
    protected val binding by lazy {
        DataBindingUtil.setContentView<ActivityDetailBinding>(
            this,
            getContentView()
        )
    }

    protected abstract fun getContentView(): Int

    // protected var progressDialog: Dialog? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
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

//    protected fun openActivity(calledActivity: Class<*>, @Nullable bundle: Bundle?) {
//        val myIntent = Intent(this, calledActivity)
//        if (bundle != null) {
//            myIntent.putExtras(bundle)
//        }
//        this.startActivity(myIntent)
//    }
//
//    protected fun openActivity(calledActivity: Class<*>) {
//        openActivity(calledActivity, null)
//    }
}
