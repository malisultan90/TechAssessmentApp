package com.mobile.techassessmentapp.di.modules

import android.app.Application
import androidx.multidex.BuildConfig
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.google.gson.internal.bind.DateTypeAdapter
import com.mobile.techassessmentapp.network.ApiService
import com.mobile.techassessmentapp.network.RequestInterceptor
import com.mobile.techassessmentapp.utils.constants.AppConstants
import com.mobile.techassessmentapp.utils.constants.AppConstants.BASE_URL
import dagger.Module
import dagger.Provides
import okhttp3.Cache
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.text.DateFormat
import java.util.*
import java.util.concurrent.TimeUnit
import javax.inject.Named
import javax.inject.Singleton

/**
 * Network layer which contains key component providers.
 */
@Module
class NetworkModule {

    /**
     * Provides [OkHttpClient] instance with pre configuration setup for default instance of Retrofit
     * which will be consumed by our network layer
     *
     * @return [OkHttpClient] instance
     */
    @Singleton
    @Provides
    @Named("default-instance")
    fun provideOkHttpClient(): OkHttpClient {
        if (BuildConfig.DEBUG) {
            val interceptor = HttpLoggingInterceptor()
            interceptor.level = HttpLoggingInterceptor.Level.BODY
            return OkHttpClient.Builder()
                .connectTimeout(AppConstants.WEB_CONNECTION_TIMEOUT, TimeUnit.SECONDS)
                .readTimeout(AppConstants.WEB_READ_TIMEOUT, TimeUnit.SECONDS)
                //.writeTimeout(AppConstants.WEB_WRITE_FILE_TIMEOUT, TimeUnit.MINUTES)
                .addInterceptor(RequestInterceptor())
                .addInterceptor(interceptor)
                .build()
        } else {
            return OkHttpClient.Builder()
                .connectTimeout(AppConstants.WEB_CONNECTION_TIMEOUT, TimeUnit.SECONDS)
                .readTimeout(AppConstants.WEB_READ_TIMEOUT, TimeUnit.SECONDS)
                //.writeTimeout(AppConstants.WEB_WRITE_FILE_TIMEOUT, TimeUnit.MINUTES)
                .addInterceptor(RequestInterceptor())
                .build()
        }


    }


    /**
     * Provides [Cache] instance for our application which would be used by [OkHttpClient] client.
     * @param application [Application] instance which will used to retrieve our cache directory of the app.
     *
     * @return [Cache] Instance.
     */
    @Provides
    @Singleton
    fun providesOkHttpCache(application: Application): Cache {
        val cacheSize = (5 * 1024 * 1024).toLong()
        return Cache(application.cacheDir, cacheSize)
    }


    /**
     * Provides [Gson] instance with pre configuration values and it would be used by [Retrofit] client.
     *
     * @return [Gson] instance
     */
    @Singleton
    @Provides
    fun provideGsonConfig(): Gson {
        return GsonBuilder()
            .setDateFormat(DateFormat.LONG)
            .registerTypeAdapter(Date::class.java, DateTypeAdapter())
            .setPrettyPrinting()
            .serializeNulls()
            .create()
    }


    /**
     * Provides [Retrofit] instance with pre configuration values and it would be used across the application.
     *
     * @return [Retrofit] instance
     */
    @Singleton
    @Provides
    @Named("default-instance")
    fun provideRetrofit(@Named("default-instance") okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(provideGsonConfig()))
            .client(okHttpClient)
            .build()
    }


    /**
     * Provides [LitteratiService] service End point instance which will be used by [Retrofit]
     * internally for creating service calls.
     * @param retrofit [Retrofit] client object
     *
     * @return [LitteratiService] instance
     */
    @Singleton
    @Provides
    fun provideApiService(@Named("default-instance") retrofit: Retrofit): ApiService {
        return retrofit.create(ApiService::class.java)
    }

}
