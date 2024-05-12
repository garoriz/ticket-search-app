package com.garif.main_feature.presentation.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.garif.main_feature.domain.entity.Offer
import com.garif.main_feature.presentation.MainFragment
import com.garif.main_feature.presentation.diffutil.OfferDiffItemCallback

class OfferListAdapter(
    private val fragment: MainFragment,
) : ListAdapter<Offer, OfferHolder>(OfferDiffItemCallback()) {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int,
    ): OfferHolder =
        OfferHolder.create(parent, fragment)

    override fun onBindViewHolder(holder: OfferHolder, position: Int) =
        holder.bind(getItem(position))

    override fun submitList(list: MutableList<Offer>?) {
        super.submitList(if (list == null) null else ArrayList(list))
    }
}