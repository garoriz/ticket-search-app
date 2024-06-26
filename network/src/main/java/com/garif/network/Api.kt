package com.garif.network

import com.garif.network.response.offers.OffersResponse
import com.garif.network.response.ticket.TicketsResponse
import com.garif.network.response.ticketsoffer.TicketsOfferResponse
import retrofit2.http.GET

interface Api {
    @GET("214a1713-bac0-4853-907c-a1dfc3cd05fd")
    suspend fun getOffers(): OffersResponse

    @GET("670c3d56-7f03-4237-9e34-d437a9e56ebf")
    suspend fun getTickets(): TicketsResponse

    @GET("7e55bf02-89ff-4847-9eb7-7d83ef884017")
    suspend fun getTicketsOffer(): TicketsOfferResponse
}