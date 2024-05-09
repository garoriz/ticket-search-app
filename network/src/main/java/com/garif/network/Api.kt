package com.garif.network

import com.garif.network.response.offers.OffersResponse
import retrofit2.http.GET

interface Api {
    @GET("00727197-24ae-48a0-bcb3-63eb35d7a9de")
    suspend fun getOffers(): OffersResponse
}