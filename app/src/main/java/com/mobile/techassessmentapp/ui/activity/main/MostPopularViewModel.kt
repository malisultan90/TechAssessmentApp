package com.mobile.techassessmentapp.ui.activity.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.mobile.techassessmentapp.model.MostPopularApiResponse
import com.mobile.techassessmentapp.model.Results
import com.mobile.techassessmentapp.network.ApiService
import com.mobile.techassessmentapp.repository.MostPopularRepository
import com.mobile.techassessmentapp.network.Resource
import com.mobile.techassessmentapp.ui.activity.base.BaseViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject


class MostPopularViewModel @Inject constructor(private val service: ApiService) :
    BaseViewModel() {

    @Inject
    lateinit var mostPopularRepo: MostPopularRepository

//    lateinit var githubUserLiveData: LiveData<Resource<MostPopularApiResponse>>
//    private val login: MutableLiveData<String> = MutableLiveData()
    val data = MutableLiveData<Resource<MostPopularApiResponse>>()
    init {
//        githubUserLiveData = login.switchMap {
//            login.value?.let {
//                mostPopularRepo.getMostPopularList()
//            }
//                ?: AbsentLiveData.create()
//        }
    }


    val repoListLive = MutableLiveData<List<Results>>()

    fun fetchRepoList(): LiveData<Resource<MostPopularApiResponse>> {
//        fun getMostPopularList(): LiveData<Resource<MostPopularApiResponse>> {
       // val data = MutableLiveData<Resource<MostPopularApiResponse>>()
        var getMostPopularList = service.getMostPopularList()
        //data.value = Resource.loading(true)
        getMostPopularList.enqueue(object : Callback<MostPopularApiResponse> {
            override fun onResponse(
                call: Call<MostPopularApiResponse>,
                response: Response<MostPopularApiResponse>
            ) {
                //data.value = Resource.loading(false)
                if (response.isSuccessful) {
                    data.value = Resource.success(response.body()!!)
                } else {
//                    val error = ErrorUtils.parseError(response)
//                    data.value =
//                        Resource.error(error.getMessage() ?: "Error", null, response.code())
                }
            }

            override fun onFailure(call: Call<MostPopularApiResponse>, t: Throwable) {
                call.cancel()
                //data.value = Resource.loading(false)
                // data.value = Resource.hostError(getCustomErrorMessageAsPerHttp(t), null)
            }
        })
        return data
    }

//    }
}