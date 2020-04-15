package com.mobile.techassessmentapp

import android.app.Activity
import androidx.multidex.MultiDexApplication
import com.mobile.techassessmentapp.di.AppInjector
import com.mobile.techassessmentapp.di.components.AppComponent
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import javax.inject.Inject


/**
 * Application class which setup dagger injection and crash reporting tool.
 * Included [MultiDexApplication] support for further development.
 *
 * @see [HasActivityInjector]
 */
class TechAssessmentApp : MultiDexApplication(), HasActivityInjector {

    @Inject
    lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Activity>

    @Inject
    lateinit var appComponent: AppComponent

    /**
     * Singleton object for [TechAssessmentApp] for future references
     */
    companion object {
        private lateinit var app: TechAssessmentApp
        fun getInstance(): TechAssessmentApp {
            return app
        }
    }

    override fun onCreate() {
        super.onCreate()
        app = this
        setupDaggerComponent()
    }

    //region Helper method for Dagger Setup
    fun setupDaggerComponent() {
        AppInjector.init(this)
        appComponent.inject(this)
    }
    //endregion

    override fun activityInjector(): DispatchingAndroidInjector<Activity>? {
        return dispatchingAndroidInjector
    }
}
