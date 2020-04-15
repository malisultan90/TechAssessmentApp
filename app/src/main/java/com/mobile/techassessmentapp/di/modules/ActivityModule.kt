package com.mobile.techassessmentapp.di.modules

import com.mobile.techassessmentapp.ui.activity.main.MainActivity
import com.mobile.techassessmentapp.ui.activity.detail.DetailActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * All [androidx.appcompat.app.AppCompatActivity] Dependency graph for [dagger.android] injection
 */
@Module
abstract class ActivityModule {

    @ContributesAndroidInjector()
    internal abstract fun contributeMainActivity(): MainActivity

    @ContributesAndroidInjector()
    internal abstract fun contributeDetailActivity(): DetailActivity

}