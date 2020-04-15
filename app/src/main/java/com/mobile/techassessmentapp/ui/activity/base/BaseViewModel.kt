package com.mobile.techassessmentapp.ui.activity.base

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

open abstract class BaseViewModel : ViewModel() {

    val empty = MutableLiveData<Boolean>().apply { value = false }

    val dataLoading = MutableLiveData<Boolean>().apply { value = false }

    val toastMessage = MutableLiveData<String>()
}