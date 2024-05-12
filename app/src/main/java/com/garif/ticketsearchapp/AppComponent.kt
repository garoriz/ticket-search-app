package com.garif.ticketsearchapp

import android.content.Context
import com.garif.blank_feature.di.BlankFeatureComponent
import com.garif.main_feature.di.MainFeatureComponent
import com.garif.selected_country_feature.di.SelectedCountryFeatureComponent
import dagger.BindsInstance
import dagger.Component

@Component
interface AppComponent {
    fun inject(mainActivity: MainActivity)

    fun createBlankComponent(): BlankFeatureComponent

    fun createMainComponent(): MainFeatureComponent

    fun createSelectedCountryComponent(): SelectedCountryFeatureComponent

    @Component.Factory
    interface AppComponentFactory {
        fun create(@BindsInstance context: Context): AppComponent
    }
}