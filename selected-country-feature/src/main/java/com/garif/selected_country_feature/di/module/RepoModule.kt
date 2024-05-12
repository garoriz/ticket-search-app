package com.garif.selected_country_feature.di.module

import com.garif.selected_country_feature.data.TicketsOfferRepoImpl
import com.garif.selected_country_feature.domain.repo.TicketsOfferRepo
import dagger.Binds
import dagger.Module

@Module
interface RepoModule {
    @Binds
    fun ticketsOfferRepo(
        impl: TicketsOfferRepoImpl
    ): TicketsOfferRepo
}