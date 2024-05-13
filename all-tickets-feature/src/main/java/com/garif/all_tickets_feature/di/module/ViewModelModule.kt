package com.garif.all_tickets_feature.di.module

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.garif.all_tickets_feature.presentation.AllTicketsViewModel
import com.garif.core1.di.ViewModelKey
import com.garif.core1.util.AppViewModelFactory
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
    @ViewModelKey(AllTicketsViewModel::class)
    fun bindAllTicketsViewModel(
        viewModel: AllTicketsViewModel
    ): ViewModel
}