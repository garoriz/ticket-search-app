package com.garif.main_feature.di.module

import com.garif.main_feature.data.OffersRepoImpl
import com.garif.main_feature.domain.repo.OffersRepo
import dagger.Binds
import dagger.Module

@Module
interface RepoModule {
    @Binds
    fun offersRepo(
        impl: OffersRepoImpl
    ): OffersRepo
}