package com.garif.selected_country_feature.di.module

import com.garif.selected_country_feature.data.mappers.TicketsOfferMapper
import dagger.Module
import dagger.Provides
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers

@Module
class SelectedCountryModule {
    @Provides
    fun provideDefaultDispatcher(): CoroutineDispatcher = Dispatchers.Default

    @Provides
    fun provideTicketsOfferMapper(): TicketsOfferMapper =
        TicketsOfferMapper()
}