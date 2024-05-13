package com.garif.all_tickets_feature.presentation.diffutil

import androidx.recyclerview.widget.DiffUtil
import com.garif.all_tickets_feature.domain.entity.Ticket

class TicketDiffItemCallback : DiffUtil.ItemCallback<Ticket>() {
    override fun areItemsTheSame(oldItem: Ticket, newItem: Ticket): Boolean =
        oldItem.id == newItem.id

    override fun areContentsTheSame(oldItem: Ticket, newItem: Ticket): Boolean = oldItem == newItem
}