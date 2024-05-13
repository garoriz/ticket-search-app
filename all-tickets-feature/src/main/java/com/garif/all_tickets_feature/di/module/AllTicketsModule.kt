package com.garif.all_tickets_feature.di.module

import com.garif.all_tickets_feature.data.mappers.TicketsMapper
import dagger.Module
import dagger.Provides
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers

@Module
class AllTicketsModule {
    @Provides
    fun provideDefaultDispatcher(): CoroutineDispatcher = Dispatchers.Default

    @Provides
    fun provideTicketsMapper(): TicketsMapper =
        TicketsMapper()
}