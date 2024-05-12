package com.garif.main_feature.di

import com.garif.network.NetworkModule
import com.garif.main_feature.di.module.MainModule
import com.garif.main_feature.di.module.RepoModule
import com.garif.main_feature.di.module.ViewModelModule
import com.garif.main_feature.presentation.MainFragment
import dagger.Subcomponent

@Subcomponent(
    modules = [
        ViewModelModule::class,
        MainModule::class,
        NetworkModule::class,
        RepoModule::class
    ]
)
interface MainFeatureComponent {
    fun injectMainFragment(mainFragment: MainFragment)
}