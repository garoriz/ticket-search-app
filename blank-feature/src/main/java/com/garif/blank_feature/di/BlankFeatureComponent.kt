package com.garif.blank_feature.di

import com.garif.blank_feature.di.module.BlankModule
import com.garif.blank_feature.presentation.BlankFragment
import dagger.Subcomponent

@Subcomponent(
    modules = [
        BlankModule::class
    ]
)
interface BlankFeatureComponent {
    fun injectBlankFragment(blankFragment: BlankFragment)
}