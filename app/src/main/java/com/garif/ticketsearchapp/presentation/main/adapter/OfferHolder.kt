package com.garif.ticketsearchapp.presentation.main.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import coil.load
import coil.transform.RoundedCornersTransformation
import com.garif.core1.PhotoMapper
import com.garif.ticketsearchapp.databinding.OfferBinding
import com.garif.ticketsearchapp.domain.entity.Offer
import com.garif.ticketsearchapp.presentation.main.MainFragment

class OfferHolder(
    private val binding: OfferBinding,
    private val fragment: MainFragment,
) : RecyclerView.ViewHolder(binding.root) {
    private var offer: Offer? = null
    private val coverCornerPx = 12f

    fun bind(offer: Offer) {
        this.offer = offer
        with(binding) {
            ivCover.load(PhotoMapper().photoMapping[offer.id]?.let {
                ContextCompat.getDrawable(
                    fragment.requireContext(),
                    it
                )
            }) {
                transformations(RoundedCornersTransformation(coverCornerPx))
            }
            tvTitle.text = offer.title
            tvTown.text = offer.town
            tvPrice.text = offer.price
        }
    }

    companion object {

        fun create(
            parent: ViewGroup,
            fragment: MainFragment,
        ) = OfferHolder(
            OfferBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            ), fragment
        )
    }
}