package org.litterati.android.di.components

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

//    fun ProfileRepository(): ProfileRepository
//
//    fun ChallengeRepository(): ChallengeRepository
//
//    fun LeaderBoardRepository(): LeaderBoardRepository


}