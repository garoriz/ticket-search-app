package com.garif.all_tickets_feature.presentation.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.garif.all_tickets_feature.domain.entity.Ticket
import com.garif.all_tickets_feature.presentation.diffutil.TicketDiffItemCallback

class TicketListAdapter : ListAdapter<Ticket, TicketHolder>(TicketDiffItemCallback()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TicketHolder {
        return TicketHolder.create(parent)
    }

    override fun onBindViewHolder(holder: TicketHolder, position: Int) {
        return holder.bind(getItem(position))
    }

    override fun submitList(list: MutableList<Ticket>?) {
        super.submitList(if (list == null) null else ArrayList(list))
    }
}