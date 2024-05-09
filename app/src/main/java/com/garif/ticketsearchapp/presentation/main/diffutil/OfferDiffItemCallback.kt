package com.garif.ticketsearchapp.presentation.main.diffutil

import androidx.recyclerview.widget.DiffUtil
import com.garif.ticketsearchapp.domain.entity.Offer

class OfferDiffItemCallback : DiffUtil.ItemCallback<Offer>() {
    override fun areItemsTheSame(oldItem: Offer, newItem: Offer): Boolean = oldItem.id == newItem.id

    override fun areContentsTheSame(oldItem: Offer, newItem: Offer): Boolean = oldItem == newItem
}