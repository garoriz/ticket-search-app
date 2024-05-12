package com.garif.selected_country_feature.data.mappers

import com.garif.network.response.ticketsoffer.TicketsOfferResponse
import com.garif.network.response.ticketsoffer.TicketsOffer
import com.garif.selected_country_feature.domain.entity.TicketOffer
import java.text.DecimalFormat
import java.text.DecimalFormatSymbols
import java.util.Locale

class TicketsOfferMapper {
    fun map(response: TicketsOfferResponse): MutableList<TicketOffer> {
        return response.tickets_offers.map(this::map) as MutableList<TicketOffer>
    }

    private fun map(ticketOffer: TicketsOffer): TicketOffer =
        TicketOffer(
            title = ticketOffer.title,
            timeRange = getFormattedTimeRange(ticketOffer.time_range),
            price = getFormattedPrice(ticketOffer.price.value)
        )

    private fun getFormattedTimeRange(timeRange: List<String>): String {
        var formattedTimeRange = ""
        for (time in timeRange)
            formattedTimeRange += "$time "
        return formattedTimeRange
    }

    private fun getFormattedPrice(price: Int): String {
        val dec = DecimalFormat("###,###,###,###,###", DecimalFormatSymbols(Locale.ENGLISH))
        val formattedPrice = dec.format(price).replace(",", " ")
        return "$formattedPrice ₽"
    }
}