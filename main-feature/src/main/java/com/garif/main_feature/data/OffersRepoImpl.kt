package com.garif.main_feature.data

import com.garif.main_feature.data.mappers.OffersMapper
import com.garif.main_feature.domain.entity.Offer
import com.garif.main_feature.domain.repo.OffersRepo
import com.garif.network.Api
import javax.inject.Inject

class OffersRepoImpl @Inject constructor(
    private val api: Api,
    private val offersMapper: OffersMapper
) : OffersRepo {
    override suspend fun getOffers(): List<Offer> {
        return offersMapper.map(api.getOffers())
    }
}