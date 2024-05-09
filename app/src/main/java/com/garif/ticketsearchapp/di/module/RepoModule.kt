package com.garif.ticketsearchapp.di.module

import com.garif.ticketsearchapp.data.OffersRepoImpl
import com.garif.ticketsearchapp.domain.repo.OffersRepo
import dagger.Binds
import dagger.Module

@Module
interface RepoModule {
    @Binds
    fun offersRepo(
        impl: OffersRepoImpl
    ): OffersRepo
}