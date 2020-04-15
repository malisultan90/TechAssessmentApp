package com.mobile.techassessmentapp.di.modules

import androidx.collection.LruCache
import androidx.lifecycle.ViewModelProvider
//import com.mobile.techassessmentapp.ui.LitteratiViewModelFactory
import dagger.Module
import dagger.Provides
import org.litterati.android.di.components.RepositoryComponent
//import org.litterati.android.di.components.ViewModelSubComponent
import javax.inject.Singleton


/***
 * App Module layer which contains dependency for our [androidx.lifecycle.AndroidViewModel],
 * [NetworkModule] layer
 */
@Module(
    subcomponents = [(RepositoryComponent::class)],
    includes = [NetworkModule::class]
)
internal class AppModule {

}