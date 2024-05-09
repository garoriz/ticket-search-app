package com.garif.ticketsearchapp.domain.repo

import com.garif.ticketsearchapp.domain.entity.Offer

interface OffersRepo {
    suspend fun getOffers(): List<Offer>
}