package com.mobile.techassessmentapp.di.modules

import androidx.collection.LruCache
import androidx.lifecycle.ViewModelProvider
import com.mobile.techassessmentapp.ui.LitteratiViewModelFactory
import dagger.Module
import dagger.Provides
import org.litterati.android.di.components.RepositoryComponent
import org.litterati.android.di.components.ViewModelSubComponent
import javax.inject.Singleton


/***
 * App Module layer which contains dependency for our [androidx.lifecycle.AndroidViewModel],
 * [NetworkModule] layer, [DatabaseModule] layer, [ImageLoadingModule] layer.
 */
@Module(
    subcomponents = [(ViewModelSubComponent::class), (RepositoryComponent::class)],
    includes = [NetworkModule::class]
)
internal class AppModule {

    /**
     * Provide [ViewModelProvider.Factory] instance from our [ViewModelSubComponent] sub component layer.
     * @param viewModelSubComponent [ViewModelSubComponent] builder
     */
    @Singleton
    @Provides
    fun provideViewModelFactory(
        viewModelSubComponent: ViewModelSubComponent.Builder
    ): ViewModelProvider.Factory {
        return LitteratiViewModelFactory(viewModelSubComponent.build())
    }
//
//    @Singleton
//    @Provides
//    fun provideLRUcache(): LruCache<String, LitterTagsResponse>{
//        return LruCache<String, LitterTagsResponse>(100)
//    }


}