package com.garif.selected_country_feature.domain.usecases

import com.garif.selected_country_feature.domain.entity.TicketOffer
import com.garif.selected_country_feature.domain.repo.TicketsOfferRepo
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class GetTicketsOfferUseCase @Inject constructor(
    private val ticketsOfferRepository: TicketsOfferRepo,
    private val dispatcher: CoroutineDispatcher = Dispatchers.IO,
) {
    suspend operator fun invoke(): List<TicketOffer> {
        return withContext(dispatcher) {
            ticketsOfferRepository.getTicketsOffers()
        }
    }
}