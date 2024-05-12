package com.garif.selected_country_feature.data

import com.garif.network.response.ticketsoffer.Price
import com.garif.network.response.ticketsoffer.TicketsOffer
import com.garif.network.response.ticketsoffer.TicketsOfferResponse
import com.garif.selected_country_feature.data.mappers.TicketsOfferMapper
import com.garif.selected_country_feature.domain.entity.TicketOffer
import com.garif.selected_country_feature.domain.repo.TicketsOfferRepo
import javax.inject.Inject

class TicketsOfferRepoImpl @Inject constructor(
    //private val api: Api,
    private val ticketsOfferMapper: TicketsOfferMapper,
) : TicketsOfferRepo {
    override suspend fun getTicketsOffers(): List<TicketOffer> {
        return ticketsOfferMapper.map(
            TicketsOfferResponse(
                listOf(
                    TicketsOffer(
                        1, Price(3999), listOf(
                            "07:00",
                            "09:10",
                            "10:00",
                            "11:30",
                            "14:15",
                            "19:10",
                            "21:00",
                            "23:30"
                        ), "Уральские авиалинии"
                    ),
                    TicketsOffer(
                        10, Price(4999), listOf(
                            "09:10",
                            "21:00"
                        ), "Победа"
                    ),
                    TicketsOffer(
                        30, Price(2390), listOf(
                            "07:00"
                        ), "NordStar"
                    )
                )
            )
        )
    }
}