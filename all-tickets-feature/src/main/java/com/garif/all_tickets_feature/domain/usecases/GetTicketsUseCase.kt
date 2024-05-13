package com.garif.all_tickets_feature.domain.usecases

import com.garif.all_tickets_feature.domain.entity.Ticket
import com.garif.all_tickets_feature.domain.repo.TicketsRepo
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class GetTicketsUseCase @Inject constructor(
    private val ticketsRepository: TicketsRepo,
    private val dispatcher: CoroutineDispatcher = Dispatchers.IO,
) {
    suspend operator fun invoke(): List<Ticket> {
        return withContext(dispatcher) {
            ticketsRepository.getTickets()
        }
    }
}