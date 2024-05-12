package com.garif.blank_feature.presentation

import android.content.Context
import androidx.fragment.app.Fragment
import com.garif.blank_feature.R
import com.garif.blank_feature.di.BlankFeatureComponentProvider

class BlankFragment : Fragment(R.layout.fragment_blank) {
    override fun onAttach(context: Context) {
        super.onAttach(context)
        (context.applicationContext as BlankFeatureComponentProvider)
            .getBlankFeatureComponent()
            .injectBlankFragment(this)
    }
}