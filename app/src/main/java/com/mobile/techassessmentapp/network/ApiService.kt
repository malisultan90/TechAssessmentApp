package com.mobile.techassessmentapp.network

import com.mobile.techassessmentapp.model.MostPopularApiResponse
import com.mobile.techassessmentapp.utils.constants.AppConstants.API_KEY
import retrofit2.Call
import retrofit2.http.*

interface ApiService {

    @GET("svc/mostpopular/v2/viewed/7.json")
    fun getMostPopularList(
        @Query("api-key") apiKey: String? = API_KEY
    ): Call<MostPopularApiResponse>
}
