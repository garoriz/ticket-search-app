package com.garif.network.response.offers

data class Offer(
    val id: Int,
    val price: Price,
    val title: String,
    val town: String
)