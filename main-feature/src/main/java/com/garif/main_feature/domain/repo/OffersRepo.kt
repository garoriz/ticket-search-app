package com.garif.main_feature.domain.repo

import com.garif.main_feature.domain.entity.Offer

interface OffersRepo {
    suspend fun getOffers(): List<Offer>
}