package org.litterati.android.di.components

import dagger.Subcomponent

/**
 * A sub component to create ViewModels. It is called by the <class>
 * [org.litterati.android.viewmodel.base.LitteratiViewModelFactory].
 */
@Subcomponent
interface ViewModelSubComponent {
    @Subcomponent.Builder
    interface Builder {
        fun build(): ViewModelSubComponent
    }

//    fun loginViewModel(): LoginViewModel
//
//    fun createChallengeViewModel(): CreateChallengeViewModel

}