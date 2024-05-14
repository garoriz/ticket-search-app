package com.garif.all_tickets_feature.data.mappers

import com.garif.network.response.ticket.Ticket
import com.garif.network.response.ticket.TicketsResponse
import java.text.DecimalFormat
import java.text.DecimalFormatSymbols
import java.time.LocalDateTime
import java.time.temporal.ChronoUnit
import java.util.Locale
import com.garif.all_tickets_feature.domain.entity.Ticket as TicketEntity

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
        val departureDateTime = LocalDateTime.parse(departureDate)
        val arrivalDateTime = LocalDateTime.parse(arrivalDate)
        val hourDifference = ChronoUnit.HOURS.between(departureDateTime, arrivalDateTime)
        val minutesDifference = ChronoUnit.MINUTES.between(departureDateTime, arrivalDateTime)
            .mod(60)
        when (minutesDifference) {
            in 46..59 -> return "${hourDifference + 1}ч в пути"
            in 16..45 -> return "${hourDifference}.5ч в пути"
            in 0..15 -> return "${hourDifference}ч в пути"
        }
        return "${hourDifference}ч в пути"
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