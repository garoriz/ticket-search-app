package com.garif.all_tickets_feature.di.module

import com.garif.all_tickets_feature.data.TicketsRepoImpl
import com.garif.all_tickets_feature.domain.repo.TicketsRepo
import dagger.Binds
import dagger.Module

@Module
interface RepoModule {
    @Binds
    fun ticketsRepo(
        impl: TicketsRepoImpl,
    ): TicketsRepo
}