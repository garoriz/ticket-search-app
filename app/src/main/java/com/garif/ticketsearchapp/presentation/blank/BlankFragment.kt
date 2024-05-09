package com.garif.ticketsearchapp.presentation.blank

import android.content.Context
import androidx.fragment.app.Fragment
import com.garif.ticketsearchapp.R
import com.garif.ticketsearchapp.di.BlankFeatureComponentProvider

class BlankFragment : Fragment(R.layout.fragment_blank) {
    override fun onAttach(context: Context) {
        super.onAttach(context)
        (context.applicationContext as BlankFeatureComponentProvider)
            .getBlankFeatureComponent()
            .injectBlankFragment(this)
    }
}