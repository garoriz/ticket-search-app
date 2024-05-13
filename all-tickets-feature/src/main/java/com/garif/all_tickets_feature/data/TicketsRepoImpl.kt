package com.garif.all_tickets_feature.data

import com.garif.all_tickets_feature.data.mappers.TicketsMapper
import com.garif.all_tickets_feature.domain.entity.Ticket
import com.garif.all_tickets_feature.domain.repo.TicketsRepo
import com.garif.network.Api
import javax.inject.Inject

class TicketsRepoImpl @Inject constructor(
    private val api: Api,
    private val ticketsMapper: TicketsMapper
) : TicketsRepo {
    override suspend fun getTickets(): List<Ticket> {
        println(api.getTickets())
        return ticketsMapper.map(api.getTickets())
    }
}