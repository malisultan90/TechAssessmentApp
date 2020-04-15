package org.litterati.android.di.components

import com.mobile.techassessmentapp.network.MostPopularRepository
import dagger.Subcomponent

/**
 * A sub component to create Repository.
 */
@Subcomponent
interface RepositoryComponent {
    @Subcomponent.Builder
    interface Builder {
        fun build(): RepositoryComponent
    }

    fun MostPopularRepository(): MostPopularRepository
}