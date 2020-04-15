package com.mobile.techassessmentapp.di.components

import android.app.Application
import com.mobile.techassessmentapp.TechAssessmentApp
import com.mobile.techassessmentapp.di.modules.AppModule
import com.mobile.techassessmentapp.di.modules.ActivityModule
import com.skydoves.githubfollows.di.ViewModelModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import retrofit2.Retrofit
import javax.inject.Named
import javax.inject.Singleton

/**
 * Application main component layer which holder all the dependencies and later would be used across the application layer.
 *
 * <p> It contains [AndroidInjectionModule] module, [AppModule] module which contains layer like network,database etc,
 *  and most importantly our activity module [ActivityModule] which will hold all the reference of our activities.
 * </p>
 */
@Singleton
@Component(modules = [(AndroidInjectionModule::class), (ViewModelModule::class), (AppModule::class), (ActivityModule::class)])
interface AppComponent {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppComponent
    }

    /**
     * Inject our application object [LiterratiApp] in dependency graph for future reference.
     * @param app [LiterratiApp] application object instance
     */
    fun inject(app: TechAssessmentApp)

    @Named("default-instance")
    fun getRetrofit(): Retrofit
}