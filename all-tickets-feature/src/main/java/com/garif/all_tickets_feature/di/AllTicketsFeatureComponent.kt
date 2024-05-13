package com.garif.all_tickets_feature.di

import com.garif.all_tickets_feature.di.module.AllTicketsModule
import com.garif.all_tickets_feature.di.module.RepoModule
import com.garif.all_tickets_feature.di.module.ViewModelModule
import com.garif.all_tickets_feature.presentation.AllTicketsFragment
import com.garif.network.NetworkModule
import dagger.Subcomponent

@Subcomponent(
    modules = [
        ViewModelModule::class,
        AllTicketsModule::class,
        NetworkModule::class,
        RepoModule::class
    ]
)
interface AllTicketsFeatureComponent {
    fun injectAllTicketsFragment(allTicketsFragment: AllTicketsFragment)
}