package com.garif.ticketsearchapp

import android.content.Context
import com.garif.ticketsearchapp.di.BlankFeatureComponent
import com.garif.ticketsearchapp.di.MainFeatureComponent
import dagger.BindsInstance
import dagger.Component

@Component
interface AppComponent {
    fun inject(mainActivity: MainActivity)

    fun createBlankComponent(): BlankFeatureComponent

    fun createMainComponent(): MainFeatureComponent

    @Component.Factory
    interface AppComponentFactory {
        fun create(@BindsInstance context: Context): AppComponent
    }
}