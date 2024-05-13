package com.garif.all_tickets_feature.data.mappers

import com.garif.network.response.ticket.Ticket
import com.garif.all_tickets_feature.domain.entity.Ticket as TicketEntity
import com.garif.network.response.ticket.TicketsResponse
import java.text.DecimalFormat
import java.text.DecimalFormatSymbols
import java.util.Locale

class TicketsMapper {
    fun map(response: TicketsResponse): MutableList<TicketEntity> {
        return response.tickets.map(this::map) as MutableList<TicketEntity>
    }

    private fun map(ticket: Ticket): TicketEntity = TicketEntity(
        id = ticket.id,
        badge = ticket.badge,
        price = getFormattedPrice(ticket.price.value),
        departureTime = getFormattedTime(ticket.departure.date),
        arrivalTime = getFormattedTime(ticket.arrival.date),
        departureAirportCode = ticket.departure.airport,
        arrivalAirportCode = ticket.arrival.airport,
        flightTime = getFlightTime(ticket.departure.date, ticket.arrival.date),
        isNonstop = ticket.has_transfer
    )

    private fun getFlightTime(departureDate: String, arrivalDate: String): String {
        return "4ч в пути"
    }

    private fun getFormattedTime(date: String): String {
        return date.drop(11).take(5)
    }

    private fun getFormattedPrice(price: Int): String {
        val dec = DecimalFormat("###,###,###,###,###", DecimalFormatSymbols(Locale.ENGLISH))
        val formattedPrice = dec.format(price).replace(",", " ")
        return "$formattedPrice ₽"
    }
}