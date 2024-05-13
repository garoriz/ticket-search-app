package com.garif.all_tickets_feature.domain.entity

data class Ticket(
    val id: Int,
    val badge: String?,
    val price: String,
    val departureTime: String,
    val arrivalTime: String,
    val departureAirportCode: String,
    val arrivalAirportCode: String,
    val flightTime: String,
    val isNonstop: Boolean,
)
