package com.garif.selected_country_feature.di

import com.garif.network.NetworkModule
import com.garif.selected_country_feature.di.module.RepoModule
import com.garif.selected_country_feature.di.module.SelectedCountryModule
import com.garif.selected_country_feature.di.module.ViewModelModule
import com.garif.selected_country_feature.presentation.SelectedCountryFragment
import dagger.Subcomponent

@Subcomponent(
    modules = [
        ViewModelModule::class,
        SelectedCountryModule::class,
        NetworkModule::class,
        RepoModule::class
    ]
)
interface SelectedCountryFeatureComponent {
    fun injectSelectedCountryFragment(selectedCountryFragment: SelectedCountryFragment)
}