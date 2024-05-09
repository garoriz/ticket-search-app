package com.garif.ticketsearchapp.domain.usecases

import com.garif.ticketsearchapp.domain.entity.Offer
import com.garif.ticketsearchapp.domain.repo.OffersRepo
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class GetOffersUseCase @Inject constructor(
    private val offersRepository: OffersRepo,
    private val dispatcher: CoroutineDispatcher = Dispatchers.IO,
) {
    suspend operator fun invoke(): List<Offer> {
        return withContext(dispatcher) {
            offersRepository.getOffers()
        }
    }
}