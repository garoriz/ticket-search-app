package com.garif.main_feature.di.module

import com.garif.main_feature.data.mappers.OffersMapper
import dagger.Module
import dagger.Provides
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers

@Module
class MainModule {
    @Provides
    fun provideDefaultDispatcher(): CoroutineDispatcher = Dispatchers.Default

    @Provides
    fun provideOffersMapper(): OffersMapper =
        OffersMapper()
}