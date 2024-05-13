package com.garif.all_tickets_feature.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.core.view.updateMargins
import androidx.recyclerview.widget.RecyclerView
import com.garif.all_tickets_feature.databinding.TicketBinding
import com.garif.all_tickets_feature.domain.entity.Ticket

class TicketHolder(
    private val binding: TicketBinding,
) : RecyclerView.ViewHolder(binding.root) {
    private var ticket: Ticket? = null

    fun bind(ticket: Ticket) {
        this.ticket = ticket
        with(binding) {
            tvPrice.text = ticket.price
            if (ticket.badge != null) {
                tvBadge.isVisible = true
                tvBadge.text = ticket.badge
            } else
                updateMargins()
            tvDepartureTime.text = ticket.departureTime
            tvArrivalTime.text = ticket.arrivalTime
            tvDepartureAirportCode.text = ticket.departureAirportCode
            tvArrivalAirportCode.text = ticket.arrivalAirportCode
            tvFlightTime.text = ticket.flightTime
            tvNonstop.isVisible = ticket.isNonstop
        }
    }

    private fun updateMargins() {
        with(binding) {
            val params = (cv.layoutParams as ViewGroup.MarginLayoutParams)
            params.updateMargins(top = 0)
        }
    }

    companion object {
        fun create(
            parent: ViewGroup,
        ) = TicketHolder(
            TicketBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }
}