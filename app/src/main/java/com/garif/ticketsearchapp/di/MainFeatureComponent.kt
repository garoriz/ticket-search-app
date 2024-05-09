package com.garif.ticketsearchapp.di

import com.garif.network.NetworkModule
import com.garif.ticketsearchapp.di.module.MainModule
import com.garif.ticketsearchapp.di.module.RepoModule
import com.garif.ticketsearchapp.di.module.ViewModelModule
import com.garif.ticketsearchapp.presentation.main.MainFragment
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