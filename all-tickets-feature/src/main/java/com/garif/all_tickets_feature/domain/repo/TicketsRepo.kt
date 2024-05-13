package com.garif.all_tickets_feature.domain.repo

import com.garif.all_tickets_feature.domain.entity.Ticket

interface TicketsRepo {
    suspend fun getTickets(): List<Ticket>
}