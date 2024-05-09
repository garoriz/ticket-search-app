package com.garif.ticketsearchapp.data.mappers

import com.garif.network.response.offers.OffersResponse
import com.garif.ticketsearchapp.domain.entity.Offer
import java.text.DecimalFormat
import java.text.DecimalFormatSymbols
import java.util.Locale
import com.garif.network.response.offers.Offer as OfferResponse

class OffersMapper {
    fun map(response: OffersResponse): MutableList<Offer> {
        return response.offers.map(this::map) as MutableList<Offer>
    }

    private fun map(offer: OfferResponse): Offer = Offer(
        id = offer.id,
        title = offer.title,
        town = offer.town,
        price = getFormattedPrice(offer.price.value)
    )

    private fun getFormattedPrice(price: Int): String {
        val dec = DecimalFormat("###,###,###,###,###", DecimalFormatSymbols(Locale.ENGLISH))
        val formattedPrice = dec.format(price).replace(",", " ")
        return "от $formattedPrice ₽ "
    }
}