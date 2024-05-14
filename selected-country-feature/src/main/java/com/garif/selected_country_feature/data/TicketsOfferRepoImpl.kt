package com.garif.selected_country_feature.data

import com.garif.network.Api
import com.garif.selected_country_feature.data.mappers.TicketsOfferMapper
import com.garif.selected_country_feature.domain.entity.TicketOffer
import com.garif.selected_country_feature.domain.repo.TicketsOfferRepo
import javax.inject.Inject

class TicketsOfferRepoImpl @Inject constructor(
    private val api: Api,
    private val ticketsOfferMapper: TicketsOfferMapper,
) : TicketsOfferRepo {
    override suspend fun getTicketsOffers(): List<TicketOffer> {
        return ticketsOfferMapper.map(api.getTicketsOffer())
    }
}