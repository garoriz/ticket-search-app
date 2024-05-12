package com.garif.selected_country_feature.di.module

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.garif.core1.di.ViewModelKey
import com.garif.core1.util.AppViewModelFactory
import com.garif.selected_country_feature.presentation.SelectedCountryViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
interface ViewModelModule {
    @Binds
    fun bindViewModelFactory(
        factory: AppViewModelFactory
    ): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(SelectedCountryViewModel::class)
    fun bindSelectedCountryViewModel(
        viewModel: SelectedCountryViewModel
    ): ViewModel
}