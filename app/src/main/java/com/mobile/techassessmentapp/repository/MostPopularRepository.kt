package com.mobile.techassessmentapp.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.mobile.techassessmentapp.model.MostPopularApiResponse
import com.mobile.techassessmentapp.network.ApiService
import com.mobile.techassessmentapp.network.Resource
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Repository class for getting Most Popular items list
 * This class is responsible for loading data and passing it as observable which can be used by anyone.
 *
 * @param service [ApiService] service instance.
 */
@Singleton
class MostPopularRepository @Inject
constructor(
    private val service: ApiService
) {
    /**
     * Fetch Most Popular items list
     *
     * @return [LiveData] instance which contains [Resource] object holding [MostPopularApiResponse] Object.
     */
    fun getMostPopularList(): LiveData<Resource<MostPopularApiResponse>> {
        val data = MutableLiveData<Resource<MostPopularApiResponse>>()
        var getMostPopularList = service.getMostPopularList()
        data.value =
            Resource.loading(true)
        getMostPopularList.enqueue(object : Callback<MostPopularApiResponse> {
            override fun onResponse(
                call: Call<MostPopularApiResponse>,
                response: Response<MostPopularApiResponse>
            ) {
                data.value =
                    Resource.loading(
                        false
                    )
                if (response.isSuccessful) {
                    data.value =
                        Resource.success(
                            response.body()!!
                        )
                } else {
//                    val error = ErrorUtils.parseError(response)
//                    data.value =
//                        Resource.error(error.getMessage() ?: "Error", null, response.code())
                }
            }

            override fun onFailure(call: Call<MostPopularApiResponse>, t: Throwable) {
                call.cancel()
                data.value =
                    Resource.loading(
                        false
                    )
                // data.value = Resource.hostError(getCustomErrorMessageAsPerHttp(t), null)
            }
        })
        return data
    }
}