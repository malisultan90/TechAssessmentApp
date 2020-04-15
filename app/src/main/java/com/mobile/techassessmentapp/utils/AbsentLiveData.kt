package com.mobile.techassessmentapp.utils

import androidx.lifecycle.LiveData

/**
 * Developed by skydoves on 2018-08-09.
 * Copyright (c) 2018 skydoves rights reserved.
 */

class AbsentLiveData<T> : LiveData<T>() {
  init {
    postValue(null)
  }

  companion object {
    fun <T> create() = AbsentLiveData<T>()
  }
}
