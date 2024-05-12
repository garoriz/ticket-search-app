package com.garif.main_feature.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import coil.load
import coil.transform.RoundedCornersTransformation
import com.garif.core1.PhotoMapper
import com.garif.main_feature.databinding.OfferBinding
import com.garif.main_feature.presentation.MainFragment

class OfferHolder(
    private val binding: OfferBinding,
    private val fragment: MainFragment,
) : RecyclerView.ViewHolder(binding.root) {
    private var offer: com.garif.main_feature.domain.entity.Offer? = null
    private val coverCornerPx = 12f

    fun bind(offer: com.garif.main_feature.domain.entity.Offer) {
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