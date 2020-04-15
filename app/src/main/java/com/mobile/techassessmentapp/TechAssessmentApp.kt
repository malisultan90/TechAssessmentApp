package com.mobile.techassessmentapp

import android.app.Activity
import android.app.Service
import androidx.multidex.MultiDexApplication
import com.mobile.techassessmentapp.di.AppInjector
import com.mobile.techassessmentapp.di.components.AppComponent
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import dagger.android.HasServiceInjector
//import timber.log.Timber
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

//    @Inject
//    lateinit var dispatchingServiceInjector: DispatchingAndroidInjector<Service>

    @Inject
    lateinit var appComponent: AppComponent

//    val callbacks = FTActivityLifecycleCallbacks(this)

//    private val profileViewIDStack = arrayListOf<Int>()

    /**
     * Singleton object for [TechAssessmentApp] for future references
     */
    companion object {
        private lateinit var app: TechAssessmentApp
        fun getInstance(): TechAssessmentApp {
            return app
        }

//        fun currentActivity(): Activity? {
//            return app.callbacks.currentActivity
//        }
    }

    override fun onCreate() {
        super.onCreate()
        app = this
       // allowDBConfigurationCreation(true)
        setupDaggerComponent()
       // setupGeneralComponents()
       // this.registerActivityLifecycleCallbacks(callbacks)
//        allowUserProfileFetchOnAppLaunch()
//        if (BuildConfig.DEBUG)
//            logFacebookHash()

        //realm?.close()
        //logRealmInstance()
    }

//    //region Setup Logging Client
//    /**
//     * Setup Logging client which we would be using in our application
//     *
//     * @see[Timber]
//     */
//    private fun setupTimber() {
//        if (BuildConfig.DEBUG) {
//            Timber.plant(Timber.DebugTree())
//        }
//    }
//    //endregion

//    //region Setup Fabric crashlytics
//
//    /**
//     * Setup Crash reporting tool i.e [Crashlytics] We will only send release crashes to it's dashboard,
//     * all [BuildConfig.DEBUG] crashes will not be pushed.
//     *
//     * @see [Fabric]
//     */
//    private fun setupFabricForCrashlytics() {
//        val crashlyticsKit = Crashlytics.Builder()
//            .core(CrashlyticsCore.Builder().disabled(BuildConfig.DEBUG).build())
//            .build()
//
//        Fabric.with(this, crashlyticsKit)
//    }
//    //endregion

    //region Helper method for Dagger Setup
    fun setupDaggerComponent() {
        AppInjector.init(this)
        appComponent.inject(this)
    }
    //endregion

//    //region Helper methods for general setup components
//    private fun setupGeneralComponents() {
//        AndroidThreeTen.init(this)
//        setupTimber()
//        setupFabricForCrashlytics()
//        HttpUtil.initializeHttpService(this)
//    }
//    //endregion

//    //region Helper method for User Profile Fetch On App Launch
//    private fun allowUserProfileFetchOnAppLaunch() {
//        LitteratiManager.getAppManager().fetchUserProfileOnAppLaunch = true
//    }
//    //endregion


    override fun activityInjector(): DispatchingAndroidInjector<Activity>? {
        return dispatchingAndroidInjector
    }

//    override fun serviceInjector(): DispatchingAndroidInjector<Service> {
//        return dispatchingServiceInjector
//    }

//    fun allowDBConfigurationCreation(createNewConfig: Boolean) {
//        LitteratiManager.getAppManager().reConfigDatabase = createNewConfig
//    }
//
//    //region Helper methods for Profile View navigation Stack opening
//    fun addProfileInStack(userProfileID: Int) {
//        this.profileViewIDStack.add(userProfileID)
//    }
//
//    fun removeProfileFromStack(userProfileID: Int) {
//        this.profileViewIDStack.remove(userProfileID)
//    }
//
//    fun isProfileStackEmpty(): Boolean = this.profileViewIDStack.isEmpty()
//
//    fun isProfileAlreadyViewed(userProfileID: Int): Boolean =
//        this.profileViewIDStack.contains(userProfileID)
//
//    //endregion

}
