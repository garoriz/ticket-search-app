package com.garif.ticketsearchapp.di

import com.garif.ticketsearchapp.di.module.BlankModule
import com.garif.ticketsearchapp.presentation.blank.BlankFragment
import dagger.Subcomponent

@Subcomponent(
    modules = [
        BlankModule::class
    ]
)
interface BlankFeatureComponent {
    fun injectBlankFragment(blankFragment: BlankFragment)
}