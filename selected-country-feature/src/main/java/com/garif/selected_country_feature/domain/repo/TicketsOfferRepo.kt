package com.garif.selected_country_feature.domain.repo

import com.garif.selected_country_feature.domain.entity.TicketOffer

interface TicketsOfferRepo {
    suspend fun getTicketsOffers(): List<TicketOffer>
}