package com.mobile.techassessmentapp.ui.activity.detail

import com.mobile.techassessmentapp.viewmodel.BaseViewModel
import javax.inject.Inject

class DetailActivityViewModel @Inject
constructor() : BaseViewModel() {

//  private val login: MutableLiveData<String> = MutableLiveData()
//  val githubUserLiveData: LiveData<Resource<GithubUser>>
//
//  init {
//    Timber.d("Injection DetailActivityViewModel")
//
//    githubUserLiveData = login.switchMap {
//      login.value?.let { user -> repository.loadUser(user) }
//        ?: AbsentLiveData.create()
//    }
//  }
//
//  fun setUser(user: String) {
//    login.value = user
//  }
//
//  fun getUserKeyName(): String = repository.getUserKeyName()
}
