package com.garif.ticketsearchapp.data

import com.garif.network.Api
import com.garif.ticketsearchapp.data.mappers.OffersMapper
import com.garif.ticketsearchapp.domain.entity.Offer
import com.garif.ticketsearchapp.domain.repo.OffersRepo
import javax.inject.Inject

class OffersRepoImpl @Inject constructor(
    private val api: Api,
    private val offersMapper: OffersMapper
) : OffersRepo {
    override suspend fun getOffers(): List<Offer> {
        return offersMapper.map(api.getOffers())
    }
}