package com.garif.ticketsearchapp.di.module

import com.garif.ticketsearchapp.data.mappers.OffersMapper
import dagger.Module
import dagger.Provides
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers

@Module
class MainModule {
    @Provides
    fun provideDefaultDispatcher(): CoroutineDispatcher = Dispatchers.Default

    @Provides
    fun provideOffersMapper(): OffersMapper = OffersMapper()
}